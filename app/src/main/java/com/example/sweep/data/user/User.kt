package com.example.sweep.data.user

import com.example.sweep.data.components.Address
import com.example.sweep.data.user.metadata.UserMetadata
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
  @SerialName("addresses")
  val addresses: List<Address>,
  @SerialName("country")
  val country: String,
  @SerialName("country_code")
  val countryCode: String,
  @SerialName("email")
  val email: String,
  @SerialName("metadata")
  val metadata: UserMetadata,
  @SerialName("password")
  val password: String,
  @SerialName("phone_number")
  val phoneNumber: String,
  @SerialName("user_type")
  val userType: String,
  @SerialName("username")
  val username: String,
  @SerialName("verified")
  val verified: Boolean
)
