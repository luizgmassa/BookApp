package com.massa.bookapp.data.repository

import android.content.Context
import com.massa.bookapp.R
import com.massa.bookapp.domain.model.Book
import com.massa.bookapp.domain.repository.BooksRepository
import com.massa.bookapp.domain.repository.Product
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.delay
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BooksRepositoryImpl @Inject constructor(
    @param:ApplicationContext private val context: Context
) : BooksRepository {

    private val books by lazy { parseBooksList() }

    @Throws(IOException::class)
    override suspend fun getBooks(): List<Book> {
        delay(1500)
        return books
    }

    @Throws(IOException::class)
    override suspend fun getBook(id: String): Book? {
        delay(1000)
        return books.find { it.id == id }
    }

    @Throws(IOException::class)
    override suspend fun searchBook(query: String): List<Book> {
        delay(100)
        return books.filter { it.name.contains(query, ignoreCase = true) }
    }

    private fun parseBooksList(): List<Book> {
        val inputStream = context.resources.openRawResource(R.raw.books_information)
        val jsonString = inputStream.bufferedReader().use { it.readText() }
        return Json.decodeFromString(
            deserializer = ListSerializer(Product.serializer()),
            string = jsonString
        ).map {
            Book(
                id = it.id,
                name = it.name,
                imageUrl = it.thumbnails.large,
                author = it.details.authors.first(),
                description = it.description.orEmpty(),
                rating = it.details.goodreadsRating.rating.toFloat(),
                reviewCount = it.details.goodreadsRating.count.toString().take(3).toInt(),
            )
        }
    }
}