package com.example.sweep.api

import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*

private var apiClient: ApiClient? = null

fun getApiClient(): ApiClient {
    if (apiClient == null) {
        apiClient = ApiClient(
            baseEndpoint = "/api/v1/sweep",
            baseUrl = "https://3hhwvlu6vagdogrz4lvcro6r6e0fvumx.lambda-url.eu-north-1.on.aws",
            httpClient = HttpClient {
                install(ContentNegotiation) {
                    json()
                }

                install(HttpTimeout) {
                    requestTimeoutMillis = 30000
                }

                install(Logging) {
                    level = LogLevel.ALL
                    logger = Logger.DEFAULT
                }
            }
        )
    }
    return apiClient!!
}