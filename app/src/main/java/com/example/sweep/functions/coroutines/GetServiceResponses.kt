package com.example.sweep.functions.coroutines

import com.example.sweep.data.components.ServiceFirmResponse
import com.example.sweep.data.components.ServiceWorkerResponse
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

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
