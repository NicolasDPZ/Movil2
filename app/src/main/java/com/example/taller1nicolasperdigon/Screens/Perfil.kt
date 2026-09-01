package com.example.taller1nicolasperdigon.Screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun Perfil(navController: NavController ){



}




@Preview(showBackground = true)
@Composable
fun prevPerfil(){
    Usuarios(navController = rememberNavController())
}