package com.teste.universecrypto.presentation.details

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.app.NavUtils
import com.bumptech.glide.Glide
import com.teste.universecrypto.R
import com.teste.universecrypto.domain.Article
import kotlinx.android.synthetic.main.activity_details.*
import java.text.SimpleDateFormat
import java.util.*

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
        Glide.with(this)
            .load(item.urlToImage)
           // .apply(RequestOptions.overrideOf(500, 800))
            .into(imageDetails)
        textTitle?.text = item.title
        textDate?.text = formateDate(item.publishedAt)
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

    @SuppressLint("SimpleDateFormat")
    override fun formateDate(date: String?): String? {

        val sdf1 = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.forLanguageTag("pt"))
        } else {
           return date
        }
        val sdf2 = SimpleDateFormat("dd-MM-yyyy hh:mma")
        return sdf2.format(sdf1.parse(date))
    }
}
