package com.example.newsapi.di

import com.example.newsapi.data.remote.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofitClient() = RetrofitClient()

    @Singleton
    @Provides
    fun provideEverythingNews(retrofitClient: RetrofitClient) = retrofitClient.provideEverythingNews()

    @Singleton
    @Provides
    fun provideTopHeadlinesNews(retrofitClient: RetrofitClient) = retrofitClient.provideTopHeadlinesNews()

    @Singleton
    @Provides
    fun provideSourcesNews(retrofitClient: RetrofitClient) = retrofitClient.provideSources()



}