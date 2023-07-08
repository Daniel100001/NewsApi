package com.example.newsapi.data.remote.apiservices

import com.example.newsapi.data.models.NewsModel
import com.example.newsapi.data.models.NewsResponse
import retrofit2.Response
import retrofit2.http.GET

interface SourcesApiService {

    @GET("top-headlines/sources")
    suspend fun fetchSourcesNews(
    ): Response<NewsResponse<NewsModel>>
}