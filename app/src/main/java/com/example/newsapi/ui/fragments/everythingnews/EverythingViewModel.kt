package com.example.newsapi.ui.fragments.everythingnews

import androidx.lifecycle.ViewModel
import com.example.newsapi.data.respositories.EverythingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EverythingViewModel @Inject constructor(
    private val repository: EverythingRepository
): ViewModel() {

    fun fetchVideoCategory() = repository.fetchEverythingBitcoinNews()

}