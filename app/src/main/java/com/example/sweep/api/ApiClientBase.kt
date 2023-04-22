package com.example.sweep.api

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

open class ApiClientBase(
  val baseEndpoint: String,
  private val httpClient: HttpClient
) {
  suspend fun delete(url: String): HttpResponse {
    return httpClient.delete("$baseEndpoint$url")
  }

  suspend fun get(url: String): HttpResponse {
    return httpClient.get("$baseEndpoint$url")
  }

  suspend fun post(data: String, url: String): HttpResponse {
    return httpClient.post("$baseEndpoint$url") {
      contentType(ContentType.Application.Json)
      setBody(data)
    }
  }

  suspend fun put(data: String, url: String): HttpResponse {
    return httpClient.put("$baseEndpoint$url") {
      contentType(ContentType.Application.Json)
      setBody(data)
    }
  }
}
