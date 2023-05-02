package com.example.sweep.context.screens.user

import com.example.sweep.context.components.ReviewContext
import com.example.sweep.data.user.ServiceProvider

data class ServiceProviderContext(
  var contextCollected: Boolean,
  var reviewContexts: List<ReviewContext>,
  var serviceProvider: ServiceProvider
)
