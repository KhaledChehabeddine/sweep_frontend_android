package com.example.sweep.api

import io.ktor.client.HttpClient
import io.ktor.client.statement.*

class ApiClient(
    baseEndpoint: String,
    baseUrl: String,
    httpClient: HttpClient
) : ApiClientBase(
    baseEndpoint = baseEndpoint,
    baseUrl = baseUrl,
    httpClient = httpClient
) {
    suspend fun createUser(data: Any): HttpResponse {
        return this.post(data = data, url = "/user/create")
    }

    suspend fun readUser(email: String): HttpResponse {
        return this.get(url = "/user/read/$email")
    }

    suspend fun updateUser(data: Any, email: String): HttpResponse {
        return this.put(data = data, url = "/user/update/$email")
    }

    suspend fun deleteUser(email: String): HttpResponse {
        return this.delete(url = "/user/delete/$email")
    }
}
