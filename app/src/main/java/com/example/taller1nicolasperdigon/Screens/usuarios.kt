package com.example.taller1nicolasperdigon.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.taller1nicolasperdigon.R

@Composable
fun Usuarios(navController: NavHostController = rememberNavController(), modifier: Modifier= Modifier){

    Scaffold(
       topBar= { TopBarUsuarios() }
    ){ padding ->
        LazyColumn(modifier= modifier
            .padding( padding)
            .fillMaxSize()
            .background(color =colorResource(id = R.color.purple_500))
        ) {


core
            okhttp
            negozation
            kotlinx json
        }
    }
}




@Composable
fun listaUsuarios(OnClick: (User) -> Unit){
    Column( Modifier = Modifier
        .fillMaxWidth()
        .clickable(onClick =))
    {
        ListItem()



    }

launched efects//para que no se haga un bucle

    LazyColumn(){
        stickyHeader {
            Header(Users:user)
        }
    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarUsuarios(){
    TopAppBar(
        title ={
            Text (text= "Total de Usuarios: ")
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorResource(id = R.color.purple_200)
        )
    )
}

@Preview(showBackground = true)
@Composable
fun prevUsuarios(){
    Usuarios(navController = rememberNavController())
}