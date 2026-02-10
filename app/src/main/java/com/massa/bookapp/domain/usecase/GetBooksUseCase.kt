package com.massa.bookapp.domain.usecase

import com.massa.bookapp.domain.model.Book
import com.massa.bookapp.domain.repository.BooksRepository

class GetBooksUseCase(
    private val booksRepository: BooksRepository
) {
    suspend operator fun invoke(): List<Book> {
        return booksRepository.getBooks()
    }
}