package com.example.gamingnews.ui.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.gamingnews.data.RssItem
import com.example.gamingnews.databinding.ListItemArticleBinding
import com.example.gamingnews.ui.details.DetailsActivity
import timber.log.Timber

class ArticleAdapter(private val context: Context?, private val articles: List<RssItem>?) :
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
        holder.itemView.setOnClickListener {
            Timber.d("Item ${article?.itemTitle} clicked!")
            /*
            Use this code if RSS Feed is not in trial mode (to open webView in app)
                val intent = Intent(context, DetailsActivity::class.java).apply {
                putExtra("ARTICLE_LINK", article?.itemLink)}
                context?.startActivity(intent)
             */

            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse(article?.itemLink)
            context?.startActivity(openURL)
            Timber.d("Opened ${article?.itemTitle} in browser!")
        }
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