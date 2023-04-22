package com.example.sweep.functions.coroutines

import com.example.sweep.api.getApiClient
import com.example.sweep.data.ApiResponse
import com.example.sweep.data.components.ServiceWorkerResponse
import io.ktor.client.statement.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

suspend fun getServiceWorkerResponses(serviceWorkerIds: List<String>): List<ServiceWorkerResponse> {
  var serviceWorkerResponses = emptyArray<ServiceWorkerResponse>()
  for (serviceWorkerId in serviceWorkerIds) {
    val response = getApiClient().readServiceFirmById(id = serviceWorkerId)
    val json = response.bodyAsText()
    val serviceWorkerResponse = Json.decodeFromString<ApiResponse<ServiceWorkerResponse>>(json).data!!
    serviceWorkerResponses += serviceWorkerResponse
  }
  return serviceWorkerResponses.toList()
}
