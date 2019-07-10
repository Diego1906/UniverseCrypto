package com.teste.universecrypto.infrastructure

import android.util.Log
import com.teste.universecrypto.R
import com.teste.universecrypto.domain.News
import com.teste.universecrypto.presentation.allnews.ListNewsContract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListNewsRepository(val presenter: ListNewsContract.Presenter) {

    private val TAG = "LIST_NEWS_REPOSITORY"

    fun getRemoteData() {

        RetrofitConfig().getService().getRemoteList().enqueue(object : Callback<News> {

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.e(TAG, "Error: ${t.message.toString()}")
            }

            override fun onResponse(call: Call<News>, response: Response<News>) {

                when (response.code()) {
                    200 -> {
                        response.body()?.articles?.let {
                            presenter.setData(it)
                        }
                    }
                    500 -> {
                        presenter.setErrorResponse(R.string.error_500)
                    }
                    else -> {
                        presenter.setErrorResponse(R.string.generic_error_remote)
                    }
                }
            }
        })
    }
}