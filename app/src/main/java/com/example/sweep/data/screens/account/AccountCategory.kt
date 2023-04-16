package com.example.sweep.data.screens.account

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AccountCategory(
  @SerialName("_id")
  val id: String,
  @SerialName("name")
  val name: String
)
