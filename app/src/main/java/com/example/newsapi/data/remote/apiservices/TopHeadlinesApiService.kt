package com.example.newsapi.data.remote.apiservices

import com.example.newsapi.data.models.NewsModel
import com.example.newsapi.data.models.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TopHeadlinesApiService {

    @GET("top-headlines")
    suspend fun fetchTopHeadlinesNews(
        @Query("country") topHeadlines : String = "us"
    ): Response<NewsResponse<NewsModel>>
}