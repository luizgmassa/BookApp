package com.massa.bookapp.presentation.screens.book_details

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.massa.bookapp.presentation.theme.BookAppTheme

@Composable
fun BookDetailsScreen(bookId: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello BookDetailsScreen!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BookAppTheme {
        BookDetailsScreen("test")
    }
}