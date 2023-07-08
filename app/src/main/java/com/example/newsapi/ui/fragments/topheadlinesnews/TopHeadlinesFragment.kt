package com.example.newsapi.ui.fragments.topheadlinesnews

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.newsapi.R
import com.example.newsapi.base.BaseFragment
import com.example.newsapi.databinding.FragmentTopHeadlinesBinding
import com.example.newsapi.ui.adapters.TopHeadlinesNewsAdapter
import com.example.newsapi.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopHeadlinesFragment : BaseFragment<FragmentTopHeadlinesBinding, TopHeadlinesViewModel>(R.layout.fragment_top_headlines) {

    override val binding by viewBinding(FragmentTopHeadlinesBinding::bind)
    override val viewModel by viewModels<TopHeadlinesViewModel>()
    private val topHeadlinesNewsAdapter = TopHeadlinesNewsAdapter()

    override fun initialize() {
        binding.recyclerViewTopHeadlinesNews.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = topHeadlinesNewsAdapter
        }
    }

    override fun setupSubscribes() {
        everythingNewsSubscribe()
    }

    private fun everythingNewsSubscribe() {
        viewModel.fetchVideoCategory().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error -> {
                    Log.e("TopHeadlinesNewsError", it.message.toString())
                }

                is Resource.Loading -> {
                    Log.e("TopHeadlinesNewsLoading", it.message.toString())
                }

                is Resource.Success -> {
                    Log.d("TopHeadlinesNewsSuccess", it.data?.articles.toString())
                    topHeadlinesNewsAdapter.submitList(it.data?.articles)
                }
            }
        }
    }
}