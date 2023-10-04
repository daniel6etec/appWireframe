package com.example.app_wireframe.navegacao

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost

import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.app_wireframe.pages.DetailPage
import com.example.app_wireframe.pages.HomePage

@Composable
fun Navegacao(){
    val navController = rememberNavController()
    NavHost(navController = navController, starDestination = "Home"){
        composable("Home"){
            HomePage(navController)
        }

        composable("Detail/{id}/?{opcional}", arguments = listOf(
            navArgument("id") { type = NavType.IntType },
            navArgument("opcional") {type = NavType.StringType },
        )) {
            val id = it.argument?.getInt("id") ?: 0
            val opcional = it.argument?.getString("opcional") ?: ""
            DetailPage(navController, id, opcional)
        }
    }
}