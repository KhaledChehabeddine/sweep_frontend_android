package com.example.sweep.context

import com.example.sweep.context.components.CategoryContext
import com.example.sweep.context.components.ReviewContext
import com.example.sweep.context.components.ServiceCategoryResponseContext
import com.example.sweep.context.components.ServiceItemResponseContext
import com.example.sweep.context.home.HomeFeatureItemResponseContext
import com.example.sweep.context.home.HomeMainFeatureItemResponseContext
import com.example.sweep.context.home.HomeSubFeatureContext

val accountContext = AccountContext(
  accountCategories = emptyList(),
  accountCategoryItemResponsesByCategory = emptyList(),
  accountContextCollected = false
)

val categoryContext = CategoryContext(
  categories = emptyList(),
  contextCollected = false,
  serviceItemResponsesMapById = hashMapOf()
)

val homeFeatureItemResponseContext = HomeFeatureItemResponseContext(
  categoriesMapById = hashMapOf(),
  contextCollected = false,
  homeFeatureItemResponses = emptyList(),
  reviewsMapById = hashMapOf(),
  serviceItemResponsesMapById = hashMapOf()
)

val homeMainFeatureItemResponseContext = HomeMainFeatureItemResponseContext(
  contextCollected = false,
  homeMainFeatureItemResponses = emptyList(),
  promotionHomeFeatureItemResponsesMapById = hashMapOf()
)

val homeSubFeatureContext = HomeSubFeatureContext(
  contextCollected = false,
  homeFeatureItemResponsesMapById = hashMapOf(),
  homeSubFeatures = emptyList()
)

val reviewContext = ReviewContext(
  contextCollected = false,
  reviews = emptyList(),
  serviceItemResponseMapById = hashMapOf()
)

val serviceCategoryResponseContext = ServiceCategoryResponseContext(
  contextCollected = false,
  serviceCategoryResponses = emptyList()
)

val serviceItemResponseContext = ServiceItemResponseContext(
  contextCollected = false,
  serviceItemResponses = emptyList()
)
