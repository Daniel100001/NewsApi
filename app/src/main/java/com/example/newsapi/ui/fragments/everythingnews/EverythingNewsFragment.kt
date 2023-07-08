package com.example.newsapi.ui.fragments.everythingnews

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.newsapi.R
import com.example.newsapi.base.BaseFragment
import com.example.newsapi.databinding.FragmentEverythingNewsBinding
import com.example.newsapi.ui.adapters.EverythingNewsAdapter
import com.example.newsapi.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EverythingNewsFragment : BaseFragment<FragmentEverythingNewsBinding, EverythingViewModel>(R.layout.fragment_everything_news) {

    override val binding by viewBinding(FragmentEverythingNewsBinding::bind)
    override val viewModel by viewModels<EverythingViewModel>()
    private val everythingNewsAdapter= EverythingNewsAdapter()

    override fun initialize() {
        binding.recyclerViewEverythingNews.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = everythingNewsAdapter
        }
    }

    override fun setupSubscribes() {
        everythingNewsSubscribe()
    }

    private fun everythingNewsSubscribe() {
        viewModel.fetchVideoCategory().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error -> {
                    Log.e("everythingNewsError", it.message.toString())
                }

                is Resource.Loading -> {
                    Log.e("EverythingNewsLoading", it.message.toString())
                }

                is Resource.Success -> {
                    Log.d("EverythingNewSuccess", it.message.toString())
                    everythingNewsAdapter.submitList(it.data?.articles)
                }
            }
        }
    }
}