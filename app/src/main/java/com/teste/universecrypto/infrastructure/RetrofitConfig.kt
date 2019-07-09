package com.teste.universecrypto.infrastructure

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig {

    private var retrofit: Retrofit
    private val URL_BASE = "https://newsapi.org"

    init {
        retrofit = Retrofit
            .Builder()
            .baseUrl(URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getService(): RetrofitAPI {
        return retrofit.create(RetrofitAPI::class.java)
    }
}