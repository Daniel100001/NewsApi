package com.example.newsapi.data.models

import com.google.gson.annotations.SerializedName

data class NewsModel(
    @SerializedName("publishedAt")
    val publishedAt: String,
    @SerializedName("author")
    val author: String,
    @SerializedName("urlToImage")
    val urlToImage: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("source")
    val source: Source,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("name")
    val name: String,
)