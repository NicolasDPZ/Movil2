package com.example.taller1nicolasperdigon.API

import com.example.taller1nicolasperdigon.Screens.User
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class UserRemoteDataSource(private val client: HttpClient) {

    suspend fun fetchUsers(limit: Int = 120): List<User> {
        val response: UsersResponse = client
            .get("https://dummyjson.com/user?limit=$limit")
            .body()
        return response.users
    }
}
