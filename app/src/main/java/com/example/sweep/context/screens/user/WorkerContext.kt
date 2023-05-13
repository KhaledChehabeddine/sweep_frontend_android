package com.example.sweep.context.screens.user

import com.example.sweep.data.user.Worker
import kotlinx.serialization.Serializable

@Serializable
data class WorkerContext(
  var contextCollected: Boolean,
  var serviceProviderContext: ServiceProviderContext,
  var worker: Worker
)
