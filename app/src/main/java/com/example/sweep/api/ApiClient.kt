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

  suspend fun readAccountCategoryByName(name: String): HttpResponse {
    return this.get(url = "/account_category/read/name/$name")
  }

  suspend fun readAccountCategoriesExcludeName(name: String): HttpResponse {
    return this.get(url = "/account_category/read/exclude/name/$name")
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

  suspend fun createCompany(data: String): HttpResponse {
    return this.post(data = data, url = "/company/create")
  }

  suspend fun readCompanyById(id: String): HttpResponse {
    return this.get(url = "/company/read/id/$id")
  }

  suspend fun readCompanies(): HttpResponse {
    return this.get(url = "/company/read")
  }

  suspend fun updateCompanyById(data: String, id: String): HttpResponse {
    return this.put(data = data, url = "/company/update/id/$id")
  }

  suspend fun deleteCompanyById(id: String): HttpResponse {
    return this.delete(url = "/company/delete/id/$id")
  }

  suspend fun createHomeMainFeaturePromotion(data: String): HttpResponse {
    return this.post(data = data, url = "/home_main_feature_promotion/create")
  }

  suspend fun readHomeMainFeaturePromotionById(id: String): HttpResponse {
    return this.get(url = "/home_main_feature_promotion/read/id/$id")
  }

  suspend fun readHomeMainFeaturePromotions(): HttpResponse {
    return this.get(url = "/home_main_feature_promotion/read")
  }

  suspend fun updateHomeMainFeaturePromotionById(data: String, id: String): HttpResponse {
    return this.put(data = data, url = "/home_main_feature_promotion/update/id/$id")
  }

  suspend fun deleteHomeMainFeaturePromotionById(id: String): HttpResponse {
    return this.delete(url = "/home_main_feature_promotion/delete/id/$id")
  }

  suspend fun createHomeMainFeatureReward(data: String): HttpResponse {
    return this.post(data = data, url = "/home_main_feature_reward/create")
  }

  suspend fun readHomeMainFeatureRewardById(id: String): HttpResponse {
    return this.get(url = "/home_main_feature_reward/read/id/$id")
  }

  suspend fun readHomeMainFeatureRewards(): HttpResponse {
    return this.get(url = "/home_main_feature_reward/read")
  }

  suspend fun updateHomeMainFeatureRewardById(data: String, id: String): HttpResponse {
    return this.put(data = data, url = "/home_main_feature_reward/update/id/$id")
  }

  suspend fun deleteHomeMainFeatureRewardById(id: String): HttpResponse {
    return this.delete(url = "/home_main_feature_reward/delete/id/$id")
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

  suspend fun createWorker(data: String): HttpResponse {
    return this.post(data = data, url = "/worker/create")
  }

  suspend fun readWorkerById(id: String): HttpResponse {
    return this.get(url = "/worker/read/id/$id")
  }

  suspend fun readWorkers(): HttpResponse {
    return this.get(url = "/worker/read")
  }

  suspend fun updateWorkerById(data: String, id: String): HttpResponse {
    return this.put(data = data, url = "/worker/update/id/$id")
  }

  suspend fun deleteWorkerById(id: String): HttpResponse {
    return this.delete(url = "/worker/delete/id/$id")
  }
}
