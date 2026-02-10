package com.massa.bookapp.di

import com.massa.bookapp.data.repository.BooksRepositoryImpl
import com.massa.bookapp.domain.repository.BooksRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface BookModule {

    @Binds
    fun bindBooksRepository(
        implementation: BooksRepositoryImpl
    ): BooksRepository
}
