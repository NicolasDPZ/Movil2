package com.example.taller1nicolasperdigon.API

import com.example.taller1nicolasperdigon.Screens.User
import kotlinx.serialization.Serializable

// https://dummyjson.com/user?limit=120 devuelve un objeto envolvente, no un array directo.
@Serializable
data class UsersResponse(
    val users: List<User>,
    val total: Int,
    val skip: Int,
    val limit: Int
)