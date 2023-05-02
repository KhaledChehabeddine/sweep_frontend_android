package com.example.sweep.data.components.metadata

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AddressMetadata(
  @SerialName("formatted_address")
  val formattedAddress: String
)
