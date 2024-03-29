package com.teste.universecrypto.presentation.allnews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.teste.universecrypto.R
import com.teste.universecrypto.domain.entities.Article
import com.teste.universecrypto.presentation.Utils.isVisible
import kotlinx.android.synthetic.main.activity_list_news.*

class ListNewsActivity : AppCompatActivity(), ListNewsContract.View {

    val presenter: ListNewsContract.Presenter = ListNewsPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_news)

        presenter.checkConnectionIsAvaliable(this)
    }

    override fun setListAdapter(listArticles: List<Article>) {
        recyclerListlNews?.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        ListNewsAdapter().apply {
            listNews = listArticles
            recyclerListlNews?.adapter = this
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

    override fun showErrorInternet() {
        Snackbar.make(
            constraintNews,
            getString(R.string.connection_off),
            Snackbar.LENGTH_INDEFINITE
        ).setAction(
            getString(R.string.try_again)
        ) {
            presenter.checkConnectionIsAvaliable(this)
        }.setActionTextColor(ContextCompat.getColor(this, android.R.color.holo_green_light))
            .show()
    }

    override fun hideLoading() {
        progress?.isVisible(false)
    }

    override fun showLoading() {
        progress?.isVisible(true)
    }
}
