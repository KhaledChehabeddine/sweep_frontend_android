package com.example.sweep.data

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse<T>(
  val data: T? = null,
  val message: String,
  val status: Int
)
