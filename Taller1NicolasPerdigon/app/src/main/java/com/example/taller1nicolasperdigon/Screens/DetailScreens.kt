package com.example.taller1nicolasperdigon.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

// Pantalla de detalle: no consulta la API, solo pinta el User que ya venía
// cargado desde la lista (ver AppNavigation, que busca el usuario por id).
// Este es un punto de partida con nombre, apellido, imagen, teléfono y
// 6 campos más — te falta el intent para llamar por teléfono al tocar el número.
@Composable
fun UserDetailScreen(user: User?, modifier: Modifier = Modifier) {
    Scaffold { padding ->
        if (user == null) {
            Text(
                text = "Usuario no encontrado",
                modifier = modifier.fillMaxSize().padding(padding).padding(16.dp)
            )
            return@Scaffold
        }

        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = user.image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
            )
            Text(text = "${user.firstName} ${user.lastName}")
            Text(text = "Teléfono: ${user.phone}")
            Text(text = "Empresa: ${user.company.name}")
            Text(text = "Email: ${user.email}")
            Text(text = "Edad: ${user.age}")
            Text(text = "Género: ${user.gender}")
            Text(text = "Altura: ${user.height}")
            Text(text = "Peso: ${user.weight}")
            Text(text = "Universidad: ${user.university}")
        }
    }
}

@Preview
@Composable
fun previewDetails(){

}