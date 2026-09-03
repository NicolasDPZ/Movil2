package com.example.taller1nicolasperdigon.API

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

// Crea el HttpClient de Ktor. Se instancia una sola vez (ver UserRemoteDataSource / Usuarios.kt)
object HttpClientFactory {

    fun create(): HttpClient {
        return HttpClient(OkHttp) {
            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true // el JSON de dummyjson trae muchos más campos de los que usamos
                        isLenient = true
                    }
                )
            }
            install(HttpTimeout) {
                requestTimeoutMillis = 15_000
            }
        }
    }
}