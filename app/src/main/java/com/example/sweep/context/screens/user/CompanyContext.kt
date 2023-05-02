package com.example.sweep.context.screens.user

import com.example.sweep.data.user.Company

data class CompanyContext(
  val company: Company,
  val contextCollected: Boolean,
  val serviceProviderContext: ServiceProviderContext
)
