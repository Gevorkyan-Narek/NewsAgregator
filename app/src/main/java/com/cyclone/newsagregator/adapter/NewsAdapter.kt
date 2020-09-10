package com.cyclone.newsagregator.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cyclone.newsagregator.R
import com.cyclone.newsagregator.network.CallBackLink
import com.cyclone.newsagregator.network.rss.RssItem
import kotlinx.android.synthetic.main.news_item.view.*

class NewsAdapter(private var news: MutableList<RssItem>, private var callBackLink: CallBackLink) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.title
        val share: ImageView = itemView.share
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = news[position].title
        holder.itemView.setOnClickListener {
            callBackLink.openLink(news[position].link)
        }
        holder.share.setOnClickListener {
            Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, news[position].link)
                type = "text/plain"
            }.let {
                holder.itemView.context.startActivity(it)
            }
        }
    }

    fun updateNews(news: List<RssItem>, position: Int) {
        this.news.addAll(news)
        notifyItemInserted(position)
    }

    override fun getItemCount(): Int = news.size
}