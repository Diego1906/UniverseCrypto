package com.teste.universecrypto.presentation.allnews

import android.content.Context
import androidx.annotation.StringRes
import com.teste.universecrypto.domain.Article

object ListNewsContract {

    interface View {
        fun showLoading()
        fun hideLoading()
        fun setListAdapter(listArticles: List<Article>)
        fun showDialogMessage(@StringRes message: Int)
        fun showErrorInternet()
    }

    interface Presenter {
        val view: View
        fun checkConnectionIsAvaliable(context: Context)
        fun getRemoteList()
        fun setErrorResponse(@StringRes message: Int)
        fun setData(listArticles: List<Article>)
    }
}