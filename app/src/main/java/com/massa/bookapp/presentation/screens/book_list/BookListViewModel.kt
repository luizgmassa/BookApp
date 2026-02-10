package com.massa.bookapp.presentation.screens.book_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.massa.bookapp.domain.usecase.GetBooksUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BookListViewModel(
    private val getBooks: GetBooksUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(BookListUiState())
    val uiState: StateFlow<BookListUiState> = _uiState

    init {
        loadBooks()
    }

    private fun loadBooks() {
        viewModelScope.launch {
            _uiState.value = BookListUiState(isLoading = true)

            val books = getBooks()

            _uiState.value = BookListUiState(books = books)
        }
    }

}