package com.example.gamingnews.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gamingnews.data.RssItem
import com.example.gamingnews.databinding.ListItemArticleBinding

class ArticleAdapter(private val context: Context, private val articles: List<RssItem>?) :
    RecyclerView.Adapter<ArticleAdapter.ArticleHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleHolder {
        val view = ListItemArticleBinding.inflate(
            LayoutInflater.from(context),
            parent,
            false
        )
        return ArticleHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleAdapter.ArticleHolder, position: Int) {
        val article: RssItem? = articles?.get(position)
        holder.bind(article)
    }

    override fun getItemCount(): Int {
        if (articles != null) {
            return articles.size
        }
        return 0
    }

    inner class ArticleHolder(private val itemBinding: ListItemArticleBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(article: RssItem?) {
            itemBinding.tvArticleName.text = article?.itemTitle
            itemBinding.tvArticleDescription.text = article?.itemPubDate
        }
    }
}