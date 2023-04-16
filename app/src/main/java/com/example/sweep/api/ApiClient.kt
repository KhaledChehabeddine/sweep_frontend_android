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

  suspend fun readAccountCategories(): HttpResponse {
    return this.get(url = "/account_category/read")
  }

  suspend fun readAccountCategoryByName(name: String): HttpResponse {
    return this.get(url = "/account_category/read/name/$name")
  }

  suspend fun updateAccountCategoryByName(data: String, name: String): HttpResponse {
    return this.put(data = data, url = "/account_category/update/name/$name")
  }

  suspend fun deleteAccountCategoryByName(name: String): HttpResponse {
    return this.delete(url = "/account_category/delete/name/$name")
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

  suspend fun readUsers(): HttpResponse {
    return this.get(url = "/user/read")
  }

  suspend fun readUserByEmail(email: String): HttpResponse {
    return this.get(url = "/user/read/email/$email")
  }

  suspend fun updateUserByEmail(data: String, email: String): HttpResponse {
    return this.put(data = data, url = "/user/update/email/$email")
  }

  suspend fun deleteUserByEmail(email: String): HttpResponse {
    return this.delete(url = "/user/delete/email/$email")
  }
}
