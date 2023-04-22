package com.example.sweep.functions.coroutines

import com.example.sweep.api.getApiClient
import com.example.sweep.data.ApiResponse
import com.example.sweep.data.components.ServiceFirmResponse
import io.ktor.client.statement.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

suspend fun getServiceFirmResponses(serviceFirmIds: List<String>): List<ServiceFirmResponse> {
  var serviceFirmResponses = emptyArray<ServiceFirmResponse>()
  for (serviceFirmId in serviceFirmIds) {
    val response = getApiClient().readServiceFirmById(id = serviceFirmId)
    val json = response.bodyAsText()
    val serviceFirmResponse = Json.decodeFromString<ApiResponse<ServiceFirmResponse>>(json).data!!
    serviceFirmResponses += serviceFirmResponse
  }
  return serviceFirmResponses.toList()
}
