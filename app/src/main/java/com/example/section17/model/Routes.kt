package com.example.section17.model

sealed class Routes(val route: String) {
    data object Pantalla1: Routes("pantalla1")
    data object Pantalla2: Routes("pantalla2/{id}") {
        fun createRoute(id: Int) = "pantalla2/$id"
    }
    data object Pantalla3: Routes("pantalla3")
    data object Pantalla5: Routes("pantalla5?name={name}") {
        fun createRoute(name: String) = "pantalla5?name=$name"
    }

}