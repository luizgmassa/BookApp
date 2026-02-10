package com.massa.bookapp.presentation.screens.book_list

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.massa.bookapp.presentation.theme.bookappTheme

@Composable
fun BookListScreen(modifier: Modifier = Modifier) {
    Text(
        text = "Hello BookListScreen!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    bookappTheme {
        BookListScreen()
    }
}