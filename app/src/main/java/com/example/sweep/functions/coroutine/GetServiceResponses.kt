package com.example.sweep.functions.coroutine

import com.example.sweep.api.getApiClient
import com.example.sweep.data.ApiResponse
import com.example.sweep.data.components.ServiceFirmResponse
import com.example.sweep.data.components.ServiceWorkerResponse
import io.ktor.client.statement.*
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

suspend fun getServiceResponses(
  serviceFirmIds: List<String>,
  serviceWorkerIds: List<String>
): Pair<List<ServiceFirmResponse>, List<ServiceWorkerResponse>> = coroutineScope {
  val deferredServiceFirmResponses = async {
    getServiceFirmResponses(serviceFirmIds = serviceFirmIds)
  }
  val deferredServiceWorkerResponses = async {
    getServiceWorkerResponses(serviceWorkerIds = serviceWorkerIds)
  }

  val serviceFirmResponses = deferredServiceFirmResponses.await().toTypedArray()
  val serviceWorkerResponses = deferredServiceWorkerResponses.await().toTypedArray()

  Pair(serviceFirmResponses.toList(), serviceWorkerResponses.toList())
}

private suspend fun getServiceFirmResponses(serviceFirmIds: List<String>): List<ServiceFirmResponse> {
  var serviceFirmResponses = emptyArray<ServiceFirmResponse>()
  for (serviceFirmId in serviceFirmIds) {
    val response = getApiClient().readServiceFirmById(id = serviceFirmId)
    val json = response.bodyAsText()
    val serviceFirmResponse = Json.decodeFromString<ApiResponse<ServiceFirmResponse>>(json).data!!
    serviceFirmResponses += serviceFirmResponse
  }
  return serviceFirmResponses.toList()
}

private suspend fun getServiceWorkerResponses(serviceWorkerIds: List<String>): List<ServiceWorkerResponse> {
  var serviceWorkerResponses = emptyArray<ServiceWorkerResponse>()
  for (serviceWorkerId in serviceWorkerIds) {
    val response = getApiClient().readServiceFirmById(id = serviceWorkerId)
    val json = response.bodyAsText()
    val serviceWorkerResponse = Json.decodeFromString<ApiResponse<ServiceWorkerResponse>>(json).data!!
    serviceWorkerResponses += serviceWorkerResponse
  }
  return serviceWorkerResponses.toList()
}
