package com.massa.bookapp.presentation.screens.book_list

import com.massa.bookapp.domain.model.Book

data class BookListUiState(
    val isLoading: Boolean = false,
    val books: List<Book> = emptyList(),
    val error: String? = null
)
