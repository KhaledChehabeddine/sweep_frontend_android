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
