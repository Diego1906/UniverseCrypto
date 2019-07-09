package com.teste.universecrypto.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.teste.universecrypto.R
import com.teste.universecrypto.domain.Article
import com.teste.universecrypto.presentation.Utils.Extensions
import kotlinx.android.synthetic.main.activity_list_news.*

class ListNewsActivity : AppCompatActivity(), ListNewsContract.View {

    val presenter: ListNewsContract.Presenter = ListNewsPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_news)

        presenter.checkConnectionIsAvaliable(this)
    }

    override fun setListAdapter(listArticles: List<Article>) {
        recyclerAllNews?.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        ListNewsAdapter().apply {
            listNews = listArticles
            recyclerAllNews?.adapter = this
        }
    }

    override fun showDialogMessage(@StringRes message: Int) {
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.title_dialog))
            .setMessage(message)
            .setPositiveButton(android.R.string.ok) { dialog, _ ->
                dialog.dismiss()
            }
            .setCancelable(false)
            .create()
    }

    override fun hideLoading() {
        progress?.hide()
    }

    override fun showLoading() {
        progress?.show()
    }

    override fun showErrorInternet() {
        messageInternet?.show()
    }

    fun View.show() {
        this.visibility = View.VISIBLE
    }

    fun View.hide() {
        this.visibility = View.INVISIBLE
    }
}
