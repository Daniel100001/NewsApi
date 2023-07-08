package com.example.newsapi.data.respositories

import com.example.newsapi.base.BaseRepository
import com.example.newsapi.data.remote.apiservices.SourcesApiService
import javax.inject.Inject

class SourcesRepository @Inject constructor(
    private val service: SourcesApiService
) : BaseRepository(){

    fun fetchSourcesNews() = doRequest {
        service.fetchSourcesNews()
    }
}