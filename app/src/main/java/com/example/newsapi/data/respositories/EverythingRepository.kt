package com.example.newsapi.data.respositories

import com.example.newsapi.base.BaseRepository
import com.example.newsapi.data.remote.apiservices.EverythingApiService
import javax.inject.Inject

class EverythingRepository @Inject constructor(
    private val service: EverythingApiService
) : BaseRepository(){

    fun fetchEverythingBitcoinNews() = doRequest {
        service.fetchEverythingBitcoinNews()
    }
}