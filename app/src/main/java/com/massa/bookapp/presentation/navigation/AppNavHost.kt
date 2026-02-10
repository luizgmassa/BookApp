package com.massa.bookapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.massa.bookapp.presentation.screens.book_details.BookDetailsScreen
import com.massa.bookapp.presentation.screens.book_list.BookListScreen
import kotlinx.serialization.Serializable

@Serializable
object BookList

@Serializable
data class BookDetails(val id: String)

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BookList) {
        composable<BookList> {
            BookListScreen(onBookClick = { id ->
                navController.navigate(BookDetails(id))
            })
        }

        composable<BookDetails> { backStackEntry ->
            val route = backStackEntry.toRoute<BookDetails>()
            BookDetailsScreen(route.id)
        }
    }
}