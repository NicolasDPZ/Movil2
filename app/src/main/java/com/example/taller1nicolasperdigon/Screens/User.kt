package com.example.taller1nicolasperdigon.Screens

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val age: Int,
    val gender: String,
    val email: String,
    val phone: String,
    val image: String,
    val height: Double,
    val weight: Double,
    val university: String,
    )
