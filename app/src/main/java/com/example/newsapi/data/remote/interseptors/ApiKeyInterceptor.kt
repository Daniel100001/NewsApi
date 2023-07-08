package com.example.newsapi.data.remote.interseptors

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request.url.newBuilder().addQueryParameter("apiKey", "8a5dee2706b64b2e90df4a81651807c3").build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}
