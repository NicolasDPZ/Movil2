package com.example.taller1nicolasperdigon.Navegacion

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.example.taller1nicolasperdigon.API.HttpClientFactory
import com.example.taller1nicolasperdigon.API.UserRemoteDataSource
import com.example.taller1nicolasperdigon.Screens.UserDetailScreen
import com.example.taller1nicolasperdigon.Screens.UserListScreen
import com.example.taller1nicolasperdigon.Screens.UserListUiState
import kotlinx.coroutines.CancellationException

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    // Pila de pantallas visitadas. Comienza mostrando la lista de usuarios.
    val backStack = remember { mutableStateListOf<Any>(UserListRoute) }

    // El origen de datos remoto se crea una sola vez mientras este composable esté vivo.
    val userRemoteDataSource = remember {
        UserRemoteDataSource(HttpClientFactory.create())
    }

    // Este es el estado de la interfaz almacenado directamente en AppNavigation.
    var state by remember { mutableStateOf(UserListUiState()) }

    // El siguiente bloque se ejecuta una sola vez, por lo que puede llamar a
    // una función suspend, sin bloquear la interfaz.
    LaunchedEffect(Unit) {
        // Se actualiza el estado para mostrar un indicador de carga.
        state = state.copy(isLoading = true, errorMessage = null)
        try {
            val users = userRemoteDataSource.fetchUsers()
            // Al terminar la consulta, se oculta el indicador de carga.
            state = state.copy(isLoading = false, users = users)
        } catch (e: CancellationException) {
            // Si el composable sale de la pantalla se captura la cancelación.
            // Se relanza para no mostrarla como un error al usuario.
            throw e
        } catch (e: Exception) {
            // Si falla la consulta, se oculta el indicador de carga.
            state = state.copy(
                isLoading = false,
                errorMessage = e.message ?: "Something went wrong"
            )
        }
    }

    NavDisplay(
        backStack = backStack,
        // Cuando el usuario navega hacia atrás se saca la última pantalla de la pila.
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<UserListRoute> {
                UserListScreen(
                    state = state,
                    // Se agrega la pantalla de detalle a la pila al hacer click.
                    onUserClick = { userId -> backStack.add(UserDetailRoute(userId)) }
                )
            }
            entry<UserDetailRoute> { route ->
                // Se busca el usuario seleccionado dentro de los datos que ya se tienen.
                UserDetailScreen(user = state.users.find { it.id == route.userId })
            }
        }
    )
}