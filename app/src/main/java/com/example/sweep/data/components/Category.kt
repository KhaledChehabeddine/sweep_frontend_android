package com.example.sweep.data.components

import com.example.sweep.data.components.metadata.CategoryMetadata
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Category(
  @SerialName("_id")
  val id: String,
  @SerialName("metadata")
  val metadata: CategoryMetadata,
  @SerialName("name")
  val name: String,
  @SerialName("service_items")
  val serviceItems: List<ServiceItem>
)
