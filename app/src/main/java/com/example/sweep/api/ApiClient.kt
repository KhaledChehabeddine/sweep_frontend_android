package com.example.sweep.api

import io.ktor.client.HttpClient
import io.ktor.client.statement.*

class ApiClient(
  baseEndpoint: String,
  httpClient: HttpClient
) : ApiClientBase(
  baseEndpoint = baseEndpoint,
  httpClient = httpClient
) {
  suspend fun createAccountCategory(data: String): HttpResponse {
    return this.post(data = data, url = "/account_category/create")
  }

  suspend fun readAccountCategoryById(id: String): HttpResponse {
    return this.get(url = "/account_category/read/id/$id")
  }

  suspend fun readAccountCategories(): HttpResponse {
    return this.get(url = "/account_category/read")
  }

  suspend fun updateAccountCategoryById(data: String, id: String): HttpResponse {
    return this.put(data = data, url = "/account_category/update/id/$id")
  }

  suspend fun deleteAccountCategoryById(id: String): HttpResponse {
    return this.delete(url = "/account_category/delete/id/$id")
  }

  suspend fun createAccountCategoryItem(data: String): HttpResponse {
    return this.post(data = data, url = "/account_category_item/create")
  }

  suspend fun readAccountCategoryItems(): HttpResponse {
    return this.get(url = "/account_category_item/read")
  }

  suspend fun readAccountCategoryItemById(id: String): HttpResponse {
    return this.get(url = "/account_category_item/read/id/$id")
  }

  suspend fun readAccountCategoryItemsByAccountCategoryName(accountCategoryName: String): HttpResponse {
    return this.get(url = "/account_category_item/read/account_category_name/$accountCategoryName")
  }

  suspend fun updateAccountCategoryItemById(data: String, id: String): HttpResponse {
    return this.put(data = data, url = "/account_category_item/update/id/$id")
  }

  suspend fun deleteAccountCategoryItemById(id: String): HttpResponse {
    return this.delete(url = "/account_category_item/delete/id/$id")
  }

  suspend fun createCategory(data: String): HttpResponse {
    return this.post(data = data, url = "/category/create")
  }

  suspend fun readCategoryById(id: String): HttpResponse {
    return this.get(url = "/category/read/id/$id")
  }

  suspend fun readCategories(): HttpResponse {
    return this.get(url = "/category/read")
  }

  suspend fun updateCategoryById(data: String, id: String): HttpResponse {
    return this.put(data = data, url = "/category/update/id/$id")
  }

  suspend fun deleteCategoryById(id: String): HttpResponse {
    return this.delete(url = "/category/delete/id/$id")
  }

  suspend fun createHomeFeatureItem(data: String): HttpResponse {
    return this.post(data = data, url = "/home_feature_item/create")
  }

  suspend fun readHomeFeatureItemById(id: String): HttpResponse {
    return this.get(url = "/home_feature_item/read/id/$id")
  }

  suspend fun readHomeFeatureItems(): HttpResponse {
    return this.get(url = "/home_feature_item/read")
  }

  suspend fun updateHomeFeatureItemById(data: String, id: String): HttpResponse {
    return this.put(data = data, url = "/home_feature_item/update/id/$id")
  }

  suspend fun deleteHomeFeatureItemById(id: String): HttpResponse {
    return this.delete(url = "/home_feature_item/delete/id/$id")
  }

  suspend fun createHomeMainFeatureItem(data: String): HttpResponse {
    return this.post(data = data, url = "/home_main_feature_item/create")
  }

  suspend fun readHomeMainFeatureItemById(id: String): HttpResponse {
    return this.get(url = "/home_main_feature_item/read/id/$id")
  }

  suspend fun readHomeMainFeatureItems(): HttpResponse {
    return this.get(url = "/home_main_feature_item/read")
  }

  suspend fun updateHomeMainFeatureItemById(data: String, id: String): HttpResponse {
    return this.put(data = data, url = "/home_main_feature_item/update/id/$id")
  }

  suspend fun deleteHomeMainFeatureItemById(id: String): HttpResponse {
    return this.delete(url = "/home_main_feature_item/delete/id/$id")
  }

  suspend fun createHomeSubFeature(data: String): HttpResponse {
    return this.post(data = data, url = "/home_sub_feature/create")
  }

  suspend fun readHomeSubFeatureById(id: String): HttpResponse {
    return this.get(url = "/home_sub_feature/read/id/$id")
  }

  suspend fun readHomeSubFeatures(): HttpResponse {
    return this.get(url = "/home_sub_feature/read")
  }

  suspend fun updateHomeSubFeatureById(data: String, id: String): HttpResponse {
    return this.put(data = data, url = "/home_sub_feature/update/id/$id")
  }

  suspend fun deleteHomeSubFeatureById(id: String): HttpResponse {
    return this.delete(url = "/home_sub_feature/delete/id/$id")
  }

  suspend fun createReview(data: String): HttpResponse {
    return this.post(data = data, url = "/review/create")
  }

  suspend fun readReviewById(id: String): HttpResponse {
    return this.get(url = "/review/read/id/$id")
  }

  suspend fun readReviews(): HttpResponse {
    return this.get(url = "/review/read")
  }

  suspend fun updateReviewById(data: String, id: String): HttpResponse {
    return this.put(data = data, url = "/review/update/id/$id")
  }

  suspend fun deleteReviewById(id: String): HttpResponse {
    return this.delete(url = "/review/delete/id/$id")
  }

  suspend fun createServiceCategory(data: String): HttpResponse {
    return this.post(data = data, url = "/service_category/create")
  }

  suspend fun readServiceCategoryById(id: String): HttpResponse {
    return this.get(url = "/service_category/read/id/$id")
  }

  suspend fun readServiceCategories(): HttpResponse {
    return this.get(url = "/service_category/read")
  }

  suspend fun updateServiceCategoryById(data: String, id: String): HttpResponse {
    return this.put(data = data, url = "/service_category/update/id/$id")
  }

  suspend fun deleteServiceCategoryById(id: String): HttpResponse {
    return this.delete(url = "/service_category/delete/id/$id")
  }

  suspend fun createServiceItem(data: String): HttpResponse {
    return this.post(data = data, url = "/service_item/create")
  }

  suspend fun readServiceItemById(id: String): HttpResponse {
    return this.get(url = "/service_item/read/id/$id")
  }

  suspend fun readServiceItems(): HttpResponse {
    return this.get(url = "/service_item/read")
  }

  suspend fun updateServiceItemById(data: String, id: String): HttpResponse {
    return this.put(data = data, url = "/service_item/update/id/$id")
  }

  suspend fun deleteServiceItemById(id: String): HttpResponse {
    return this.delete(url = "/service_item/delete/id/$id")
  }

  suspend fun createUser(data: String): HttpResponse {
    return this.post(data = data, url = "/user/create")
  }

  suspend fun readUserById(id: String): HttpResponse {
    return this.get(url = "/user/read/id/$id")
  }

  suspend fun readUsers(): HttpResponse {
    return this.get(url = "/user/read")
  }

  suspend fun updateUserById(data: String, id: String): HttpResponse {
    return this.put(data = data, url = "/user/update/id/$id")
  }

  suspend fun deleteUserById(id: String): HttpResponse {
    return this.delete(url = "/user/delete/id/$id")
  }
}
