package com.example.newsapi.ui.fragments.topheadlinesnews

import androidx.lifecycle.ViewModel
import com.example.newsapi.data.remote.apiservices.TopHeadlinesApiService
import com.example.newsapi.data.respositories.TopHeadlinesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TopHeadlinesViewModel @Inject constructor(
    private val repository: TopHeadlinesRepository
): ViewModel() {

    fun fetchVideoCategory() = repository.fetchTopHeadlinesNews()
}