package com.example.sweep.data.components

import com.example.sweep.data.components.metadata.AddressMetadata
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Address(
  @SerialName("city")
  val city: String,
  @SerialName("country")
  val country: String,
  @SerialName("latitude")
  val latitude: Float,
  @SerialName("longitude")
  val longitude: Float,
  @SerialName("metadata")
  val metadata: AddressMetadata,
  @SerialName("name")
  val name: String,
  @SerialName("state")
  val state: String,
  @SerialName("street_address_1")
  val streetAddress1: String,
  @SerialName("street_address_2")
  val streetAddress2: String,
  @SerialName("zip_code")
  val zipCode: String
)
