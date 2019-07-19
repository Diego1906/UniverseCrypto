package com.teste.universecrypto.presentation.allnews

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.teste.universecrypto.R
import com.teste.universecrypto.domain.Article
import com.teste.universecrypto.presentation.details.DetailsActivity
import kotlinx.android.synthetic.main.item_news.view.*

class ListNewsAdapter : RecyclerView.Adapter<ListNewsAdapter.ItemHolder>() {

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

        holder.itemView.setOnClickListener {
            item.let {
                val bundle = Bundle()
                bundle.putSerializable(holder.itemView.context.getString(R.string.item), item)

                val intent = Intent(holder.itemView.context, DetailsActivity::class.java)
                intent.putExtras(bundle)
                holder.itemView.context.startActivity(intent)
            }
        }
    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val image = itemView.imageItem
        val title = itemView.titleItem
        val description = itemView.descriptionItem
    }
}







