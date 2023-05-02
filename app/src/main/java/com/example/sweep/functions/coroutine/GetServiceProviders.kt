package com.example.sweep.functions.coroutine

import com.example.sweep.api.getApiClient
import com.example.sweep.context.components.ReviewContext
import com.example.sweep.context.screens.user.CompanyContext
import com.example.sweep.context.screens.user.ServiceProviderContext
import com.example.sweep.context.screens.user.WorkerContext
import com.example.sweep.data.ApiResponse
import com.example.sweep.data.components.Review
import com.example.sweep.data.user.Company
import com.example.sweep.data.user.ServiceProvider
import com.example.sweep.data.user.Worker
import io.ktor.client.statement.*
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

suspend fun getServiceProviderContexts(
  companyIds: List<String>,
  workerIds: List<String>
): Pair<List<CompanyContext>, List<WorkerContext>> = coroutineScope {
  val deferredCompanies = async {
    getCompanies(companyIds = companyIds)
  }
  val deferredWorkers = async {
    getWorkers(workerIds = workerIds)
  }

  val companies = deferredCompanies.await()
  val deferredCompanyContexts = async {
    getCompanyContexts(companies = companies)
  }

  val workers = deferredWorkers.await()
  val deferredWorkerContexts = async {
    getWorkerContexts(workers = workers)
  }

  val companyContexts = deferredCompanyContexts.await()
  val workerContexts = deferredWorkerContexts.await()

  Pair(companyContexts, workerContexts)
}

private suspend fun getCompanies(companyIds: List<String>): List<Company> {
  var companies = emptyArray<Company>()
  for (companyId in companyIds) {
    val response = getApiClient().readCompanyById(id = companyId)
    val json = response.bodyAsText()
    val company = Json.decodeFromString<ApiResponse<Company>>(json).data!!
    companies += company
  }
  return companies.toList()
}

private suspend fun getWorkers(workerIds: List<String>): List<Worker> {
  var workers = emptyArray<Worker>()
  for (workerId in workerIds) {
    val response = getApiClient().readWorkerById(id = workerId)
    val json = response.bodyAsText()
    val worker = Json.decodeFromString<ApiResponse<Worker>>(json).data!!
    workers += worker
  }
  return workers.toList()
}

private suspend fun getCompanyContexts(companies: List<Company>): List<CompanyContext> {
  var companyContexts = emptyArray<CompanyContext>()
  for (company in companies) {
    val serviceProviderContext = getServiceProviderContext(serviceProvider = company.serviceProvider)
    companyContexts += CompanyContext(
      company = company,
      contextCollected = true,
      serviceProviderContext = serviceProviderContext
    )
  }
  return companyContexts.toList()
}

private suspend fun getWorkerContexts(workers: List<Worker>): List<WorkerContext> {
  var workerContexts = emptyArray<WorkerContext>()
  for (worker in workers) {
    val serviceProviderContext = getServiceProviderContext(serviceProvider = worker.serviceProvider)
    workerContexts += WorkerContext(
      contextCollected = true,
      serviceProviderContext = serviceProviderContext,
      worker = worker
    )
  }
  return workerContexts.toList()
}

private suspend fun getServiceProviderContext(
  serviceProvider: ServiceProvider
): ServiceProviderContext = coroutineScope {
  val reviewContexts = getReviewContexts(reviews = serviceProvider.reviews)

  ServiceProviderContext(
    contextCollected = true,
    reviewContexts = reviewContexts.toList(),
    serviceProvider = serviceProvider
  )
}

private fun getReviewContexts(reviews: List<Review>): List<ReviewContext> {
  var reviewContexts = emptyArray<ReviewContext>()
  for (review in reviews) {
    val reviewContext = ReviewContext(
      contextCollected = true,
      review = review
    )
    reviewContexts += reviewContext
  }
  return reviewContexts.toList()
}
