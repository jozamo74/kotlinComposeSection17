package com.example.section17

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.section17.model.Routes.*
import com.example.section17.ui.theme.Section17Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Section17Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android")
                    val navigationController = rememberNavController()
                    NavHost(
                        navController = navigationController,
                        startDestination = Pantalla1.route
                    ) {
                        composable(Pantalla1.route) { Screen1(navigationController) }
                        composable(
                            Pantalla2.route,
                            arguments = listOf(navArgument("id") { type = NavType.IntType })
                        ) {
                            Screen2(
                                navigationController,
                                it.arguments?.getInt("id") ?: 0
                            )
                        }
                        composable(Pantalla3.route) { Screen3(navigationController) }
                        composable("pantalla4/{name}") { navBackStackEntry ->
                            Screen4(
                                navigationController = navigationController,
                                navBackStackEntry.arguments?.getString("name")!!
                            )
                        }
                        composable(
                            Pantalla5.route,
                            arguments = listOf(navArgument("name") { defaultValue = "" })
                        ) {
                            Screen5(
                                navigationController = navigationController,
                                it.arguments?.getString("name")
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Section17Theme {
        Greeting("Android")
    }
}