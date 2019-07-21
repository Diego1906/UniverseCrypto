package com.teste.universecrypto.infrastructure

import com.teste.universecrypto.domain.entities.News
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitAPI {

    @GET("/v2/everything?q=crypto&language=en&from=2019-07-19&apiKey=17a6e330527149d99095181e37557fe6")
    fun getRemoteList(): Call<News>
}