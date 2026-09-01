package com.example.taller1nicolasperdigon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.taller1nicolasperdigon.Screens.Usuarios
import com.example.taller1nicolasperdigon.ui.theme.Taller1NicolasPerdigonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Taller1NicolasPerdigonTheme {
                    Navegacion()
            }
        }
    }
}


@Composable
fun Navegacion() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "venta") {
        composable("Usuarios") {
            Usuarios(navController = navController)
        }
    }
}