package com.teste.universecrypto.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.teste.universecrypto.R
import com.teste.universecrypto.domain.Article
import kotlinx.android.synthetic.main.item_news.view.*

class ListNewsAdapter : RecyclerView.Adapter<ItemHolder>() {

    var listNews = listOf<Article>()
        set(value) {
            if (field != value) {
                field = value
                notifyDataSetChanged()
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {

        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_news, parent, false)
        return ItemHolder(view)
    }

    override fun getItemCount(): Int = listNews.size

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {

        val item = listNews[position]

        Glide.with(holder.itemView)
            .load(item.urlToImage)
            .apply(RequestOptions().override(200, 500))
            .placeholder(R.drawable.ic_placeholder)
            .into(holder.image)
        holder.title.text = item.title
        holder.description.text = item.description
    }
}

class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val image = itemView.imageItem
    val title = itemView.titleItem
    val description = itemView.descriptionItem
}






