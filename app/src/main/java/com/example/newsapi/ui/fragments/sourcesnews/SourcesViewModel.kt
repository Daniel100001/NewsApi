package com.example.newsapi.ui.fragments.sourcesnews

import androidx.lifecycle.ViewModel
import com.example.newsapi.data.respositories.SourcesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SourcesViewModel @Inject constructor(
    private val repository: SourcesRepository
): ViewModel() {

    fun fetchSourcesNews() = repository.fetchSourcesNews()
}