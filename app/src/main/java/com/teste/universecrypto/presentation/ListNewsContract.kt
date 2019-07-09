package com.teste.universecrypto.presentation

import android.content.Context
import androidx.annotation.StringRes
import com.teste.universecrypto.domain.Article
import com.teste.universecrypto.presentation.Utils.Extensions

object ListNewsContract {

    interface View {
        fun showLoading()
        fun hideLoading()
        fun showErrorInternet()
        fun setListAdapter(listArticles: List<Article>)
        fun showDialogMessage(@StringRes message: Int)
    }

    interface Presenter {
        val view: View
        fun checkConnectionIsAvaliable(context: Context)
        fun getRemoteList()
        fun setErrorResponse(@StringRes message: Int)
        fun setData(listArticles: List<Article>)
    }

    interface Model {

    }
}