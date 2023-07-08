package com.example.newsapi.data.respositories

import com.example.newsapi.base.BaseRepository
import com.example.newsapi.data.remote.apiservices.TopHeadlinesApiService
import javax.inject.Inject

class TopHeadlinesRepository @Inject constructor(
    private val service: TopHeadlinesApiService
) : BaseRepository(){

    fun fetchTopHeadlinesNews() = doRequest {
        service.fetchTopHeadlinesNews()
    }
}