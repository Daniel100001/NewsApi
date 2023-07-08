package com.example.newsapi.data.remote.apiservices

import com.example.newsapi.data.models.NewsModel
import com.example.newsapi.data.models.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface EverythingApiService {

    @GET("everything")
    suspend fun fetchEverythingBitcoinNews(
        @Query("q") bitcoinNews: String = "+bitcoin",
    ): Response<NewsResponse<NewsModel>>
}
