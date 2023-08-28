package com.example.starwarsship.di

import com.example.starwarsship.data.ApiService
import com.example.starwarsship.data.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideMainRepository(apiService: ApiService): MainRepository = MainRepository(apiService)

}