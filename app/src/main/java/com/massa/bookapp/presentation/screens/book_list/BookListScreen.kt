package com.massa.bookapp.presentation.screens.book_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.massa.bookapp.domain.model.Book
import com.massa.bookapp.presentation.theme.BookAppTheme

@Composable
fun BookListScreen(
    modifier: Modifier = Modifier,
    viewModel: BookListViewModel = viewModel(),
    onBookClick: (String) -> Unit
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    BookListContent(modifier = modifier, state = state, onBookClick = onBookClick)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookListContent(
    modifier: Modifier,
    state: BookListUiState,
    onBookClick: (String) -> Unit,
) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Books") }) },
        modifier = modifier
    ) { paddingValues ->
        when {
            state.isLoading -> {
                CircularProgressIndicator()
            }

            state.error != null -> {
                Text("Error: ${state.error}")
            }

            else -> {
                LazyColumn(modifier.padding(paddingValues)) {
                    items(state.books) { book ->
                        Text(
                            text = book.name,

                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    onBookClick(book.id)
                                }
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BookAppTheme {
        BookListContent(
            modifier = Modifier,
            state = BookListUiState(
                books = listOf(
                    Book(
                        id = "1",
                        name = "The Great Gatsby",
                        author = "F. Scott Fitzgerald",
                        imageUrl = "",
                        description = "A story of wealth and love.",
                        rating = 4.5f,
                        reviewCount = 120
                    ),
                    Book(
                        id = "2",
                        name = "1984",
                        author = "George Orwell",
                        imageUrl = "",
                        description = "Dystopian future.",
                        rating = 4.8f,
                        reviewCount = 300
                    )
                )
            ),
            onBookClick = { }
        )
    }
}