package com.example.newsapi.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapi.data.models.NewsModel
import com.example.newsapi.databinding.ItemSourcesNewsBinding

class SourcesNewsAdapter :
    ListAdapter<NewsModel, SourcesNewsAdapter.SourcesNewsViewHolder>(DiffUtilCallback()) {

    inner class SourcesNewsViewHolder(private val binding: ItemSourcesNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: NewsModel) = with(binding) {
            name.text = item.name
            description.text = item.description
            url.text = item.url

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SourcesNewsViewHolder {
        return SourcesNewsViewHolder(
            ItemSourcesNewsBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SourcesNewsViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    companion object {
        class DiffUtilCallback : DiffUtil.ItemCallback<NewsModel>() {
            override fun areItemsTheSame(oldItem: NewsModel, newItem: NewsModel): Boolean {
                return oldItem.source.id == newItem.source.id
            }

            override fun areContentsTheSame(
                oldItem: NewsModel,
                newItem: NewsModel,
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}