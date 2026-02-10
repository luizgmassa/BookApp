package com.massa.bookapp.domain.repository

import com.massa.bookapp.domain.model.Book

interface BooksRepository {
    suspend fun getBooks(): List<Book>
    suspend fun getBook(id: String): Book?
    suspend fun searchBook(query: String): List<Book>
}

