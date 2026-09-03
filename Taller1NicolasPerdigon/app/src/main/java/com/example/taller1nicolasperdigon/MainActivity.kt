package com.example.taller1nicolasperdigon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.taller1nicolasperdigon.Navegacion.AppNavigation
import com.example.taller1nicolasperdigon.ui.theme.Taller1NicolasPerdigonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Taller1NicolasPerdigonTheme {
                AppNavigation()
            }
        }
    }
}