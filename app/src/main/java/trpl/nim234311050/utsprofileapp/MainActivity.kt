package trpl.nim234311050.utsprofileapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.compose.*
import trpl.nim234311050.utsprofileapp.ui.theme.*
import trpl.nim234311050.utsprofileapp.viewmodel.UserViewModel

class MainActivity : ComponentActivity() {

    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UTSProfileAppTheme {
                Surface {
                    UTSProfileApp(userViewModel)
                }
            }
        }
    }
}

@Composable
fun UTSProfileApp(viewModel: UserViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(
                viewModel = viewModel,
                onLoginSuccess = {
                    if (viewModel.currentUser != null) {
                        navController.navigate("home") {
                            popUpTo("login") { inclusive = true }
                        }
                    }
                },
                onNavigateToRegister = {
                    navController.navigate("register")
                }
            )
        }

        composable("register") {
            RegisterScreen(
                viewModel = viewModel,
                onRegisterSuccess = {
                    navController.popBackStack()
                },
                onNavigateToLogin = {
                    navController.popBackStack()
                }
            )
        }

        composable("home") {
            HomeScreen(
                user = viewModel.currentUser,
                onUpdateClick = {
                    navController.navigate("update")
                },
                onLogoutClick = {
                    viewModel.logout()
                    navController.navigate("login") {
                        popUpTo("home") { inclusive = true }
                    }
                }
            )
        }

        composable("update") {
            UpdateProfileScreen(
                viewModel = viewModel,
                onUpdated = {
                    navController.popBackStack()
                }
            )
        }
    }
}
