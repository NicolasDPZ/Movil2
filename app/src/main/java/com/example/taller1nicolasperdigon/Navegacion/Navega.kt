package com.example.taller1nicolasperdigon.Navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.taller1nicolasperdigon.Screens.Perfil
import com.example.taller1nicolasperdigon.Screens.Usuarios

@Composable
fun NavegacionApp(){
    var navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Pantallas.usuarios.name
    ) {

        composable(route = Pantallas.usuarios.name){
            Usuarios(navController= navController)
        }
        composable (route= Pantallas.Perfil.name) {
            Perfil(navController= navController)
        }
    }

}