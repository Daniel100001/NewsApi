package com.example.newsapi.ui.fragments.sourcesnews

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.newsapi.R
import com.example.newsapi.base.BaseFragment
import com.example.newsapi.databinding.FragmentSourcesNewsBinding
import com.example.newsapi.ui.adapters.SourcesNewsAdapter
import com.example.newsapi.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SourcesNewsFragment : BaseFragment<FragmentSourcesNewsBinding, SourcesViewModel>(R.layout.fragment_sources_news) {

    override val binding by viewBinding(FragmentSourcesNewsBinding::bind)
    override val viewModel by viewModels<SourcesViewModel>()
    private val sourcesNewsAdapter = SourcesNewsAdapter()

    override fun initialize() {
        binding.recyclerViewSourcesNews.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = sourcesNewsAdapter
        }
    }

    override fun setupSubscribes() {
        everythingNewsSubscribe()
    }

    private fun everythingNewsSubscribe() {
        viewModel.fetchSourcesNews().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error -> {
                    Log.e("SourcesNewsError", it.message.toString())
                }

                is Resource.Loading -> {
                    Log.e("SourcesNewsLoading", it.message.toString())
                }

                is Resource.Success -> {
                    Log.d("SourcesNewsSuccess", it.data?.sources.toString())
                    sourcesNewsAdapter.submitList(it.data?.sources)
                }
            }
        }
    }
}