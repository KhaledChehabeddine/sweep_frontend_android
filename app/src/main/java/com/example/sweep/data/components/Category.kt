package com.example.sweep.data.components

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Category(
  @SerialName("_id")
  val id: String,
  @SerialName("name")
  val name: String,
  @SerialName("service_item_ids")
  val serviceItemIds: List<String>
)
