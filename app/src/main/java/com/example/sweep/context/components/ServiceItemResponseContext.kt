package com.example.sweep.context.components

import com.example.sweep.data.components.ServiceItemResponse

data class ServiceItemResponseContext(
  var contextCollected: Boolean,
  var serviceItemResponses: List<ServiceItemResponse>
)
