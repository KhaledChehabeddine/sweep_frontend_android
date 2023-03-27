package com.example.sweep.api

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.util.*

open class ApiClientBase(
    val baseEndpoint: String,
    val baseUrl: String,
    private val httpClient: HttpClient
) {
    suspend fun delete(url: String): HttpResponse {
        return httpClient.delete("$baseEndpoint$baseUrl$url")
    }

    suspend fun get(url: String): HttpResponse {
        return httpClient.get("$baseEndpoint$baseUrl$url")
    }

    @OptIn(InternalAPI::class)
    suspend fun post(data: Any, url: String): HttpResponse {
        return httpClient.post("$baseEndpoint$baseUrl$url") {
            contentType(ContentType.Application.Json)
            body = data
        }
    }

    @OptIn(InternalAPI::class)
    suspend fun put(data: Any, url: String): HttpResponse {
        return httpClient.put("$baseEndpoint$baseUrl$url") {
            contentType(ContentType.Application.Json)
            body = data
        }
    }
}
