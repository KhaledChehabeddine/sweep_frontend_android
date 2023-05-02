package com.example.sweep.api

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*

// val BASE_ENDPOINT = System.getenv("BASE_ENDPOINT")?.toString()!!
// val BASE_URL =
//  if (System.getenv("IS_PRODUCTION").toBoolean()) {
//    System.getenv("PRODUCTION_BASE_URL")?.toString()!!
//  } else {
//    System.getenv("DEVELOPMENT_BASE_URL")?.toString()!!
//  }

// TODO: Change this to use environment variables defined above
const val BASE_ENDPOINT = "/api/v1/sweep"
const val BASE_URL = "10.0.2.2"

private var apiClient: ApiClient? = null

fun getApiClient(): ApiClient {
  if (apiClient == null) {
    apiClient = ApiClient(
      baseEndpoint = BASE_ENDPOINT,
      httpClient = HttpClient(Android) {
        defaultRequest {
          host = BASE_URL
          port = 5000
          url {
            protocol = URLProtocol.HTTP
          }
        }

        engine { }

        install(ContentNegotiation) {
          json()
        }
      }
    )
  }
  return apiClient!!
}
