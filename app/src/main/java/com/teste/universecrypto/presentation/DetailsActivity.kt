package com.teste.universecrypto.presentation

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.app.NavUtils
import com.teste.universecrypto.R
import com.teste.universecrypto.domain.Article
import kotlinx.android.synthetic.main.activity_details.*
import java.net.URI

class DetailsActivity : AppCompatActivity(), DetailsContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        supportActionBar?.setDisplayShowHomeEnabled(true)

        val bundle = intent.extras
        bundle?.let {
            if (it.containsKey("ITEM")) {
                setDetailsData(it.getSerializable("ITEM") as Article)
            }
        }
    }

    override fun setDetailsData(item: Article) {
        textTitle?.text = item.title
        textDate?.text = item.publishedAt
        textContent?.text = item.content
        textAuthor?.text = item.author

        textMore?.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse(item.url))
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                NavUtils.navigateUpFromSameTask(this)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
