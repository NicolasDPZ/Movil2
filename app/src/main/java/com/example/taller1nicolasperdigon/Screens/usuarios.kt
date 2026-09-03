package com.example.taller1nicolasperdigon.Screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.taller1nicolasperdigon.R

// Estado de la lista de usuarios. Ahora lo maneja AppNavigation, porque la
// consulta a la API se hace ahí una sola vez y se comparte con el detalle.
data class UserListUiState(
    val isLoading: Boolean = false,
    val users: List<User> = emptyList(),
    val errorMessage: String? = null
)

@Composable
fun UserListScreen(
    state: UserListUiState,
    modifier: Modifier = Modifier,
    onUserClick: (Int) -> Unit = {}
) {
    Scaffold(
        topBar = { TopBarUsuarios() }
    ) { padding ->
        when {
            state.isLoading -> {
                Surface(modifier = modifier.fillMaxSize().padding(padding)) {
                    CircularProgressIndicator(modifier = Modifier.padding(16.dp))
                }
            }
            state.errorMessage != null -> {
                Surface(modifier = modifier.fillMaxSize().padding(padding)) {
                    Text(text = state.errorMessage.orEmpty(), modifier = Modifier.padding(16.dp))
                }
            }
            else -> {
                ListaUsuarios(
                    users = state.users,
                    modifier = modifier.fillMaxSize().padding(padding),
                    onUserClick = onUserClick
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ListaUsuarios(
    users: List<User>,
    modifier: Modifier = Modifier,
    onUserClick: (Int) -> Unit
) {
    LazyColumn(modifier = modifier) {
        stickyHeader{
            Surface(color = colorResource(id = R.color.purple_200)) {
                Text(
                    text = "Total usuarios: ${users.size}",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                )
            }
        }

        items(users, key = { it.id }) { user ->
            ListItem(
                headlineContent = { Text("${user.firstName} ${user.lastName}") },
                supportingContent = { Text(user.company.name) },
                leadingContent = {
                    AsyncImage(
                        model = user.image,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(48.dp)
                            .clip(CircleShape)
                    )
                },
                // Ahora se navega mandando solo el id; AppNavigation ya tiene la lista completa.
                modifier = Modifier.clickable { onUserClick(user.id) }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarUsuarios() {
    TopAppBar(
        title = { Text(text = "Usuarios") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorResource(id = R.color.purple_500)
        )
    )
}

