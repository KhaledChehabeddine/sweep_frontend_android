package com.example.sweep.context

val accountContext = AccountContext(
  accountCategories = emptyList(),
  accountCategoryItemResponsesByCategory = emptyList(),
  accountContextCollected = false
)

val homeContext = HomeContext(
  homeContextCollected = false,
  homeFeatureItemResponses = emptyList(),
  homeMainFeatureItemResponses = emptyList(),
  homeSubFeatures = emptyList()
)

val utilityContext = UtilityContext(
  categories = emptyList(),
  reviews = emptyList(),
  serviceCategoryResponses = emptyList(),
  serviceItemResponses = emptyList(),
  utilityContextCollected = false
)
