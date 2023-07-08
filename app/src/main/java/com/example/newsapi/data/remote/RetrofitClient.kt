package com.example.newsapi.data.remote

import com.example.newsapi.data.remote.apiservices.EverythingApiService
import com.example.newsapi.data.remote.apiservices.SourcesApiService
import com.example.newsapi.data.remote.apiservices.TopHeadlinesApiService
import com.example.newsapi.data.remote.interseptors.ApiKeyInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private val okkHttClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(provideLoggingInterceptor())
        .addInterceptor(ApiKeyInterceptor())
        .callTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    private val retrofitClient = Retrofit.Builder()
        .baseUrl("https://newsapi.org/v2/")
        .client(okkHttClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private fun provideLoggingInterceptor() = HttpLoggingInterceptor().setLevel(
        HttpLoggingInterceptor.Level.BODY)

     fun provideEverythingNews() = retrofitClient.create(EverythingApiService::class.java)

     fun provideTopHeadlinesNews() = retrofitClient.create(TopHeadlinesApiService::class.java)

    fun provideSources() = retrofitClient.create(SourcesApiService::class.java)

}