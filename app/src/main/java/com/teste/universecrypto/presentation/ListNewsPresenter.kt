package com.teste.universecrypto.presentation

import android.content.Context
import android.net.ConnectivityManager
import androidx.annotation.StringRes
import com.teste.universecrypto.domain.Article
import com.teste.universecrypto.infrastructure.ListNewsRepository

class ListNewsPresenter(override val view: ListNewsContract.View) : ListNewsContract.Presenter {

    private val repository by lazy {
        ListNewsRepository(this)
    }

    override fun checkConnectionIsAvaliable(context: Context) {

        val connectivityManager: ConnectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val networkInfo = connectivityManager.activeNetworkInfo

        if (networkInfo != null && networkInfo.isConnected)
            getRemoteList()
        else
            view.showErrorInternet()
    }

    override fun getRemoteList() {
        repository.getRemoteData()
    }

    override fun setErrorResponse(@StringRes message: Int) {
        view.showDialogMessage(message)
    }

    override fun setData(listArticles: List<Article>) {
        listArticles.let {
            view.setListAdapter(it)
        }
    }
}