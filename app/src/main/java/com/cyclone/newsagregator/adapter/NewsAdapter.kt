package com.cyclone.newsagregator.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cyclone.newsagregator.R
import com.cyclone.newsagregator.network.CallBackLink
import com.cyclone.newsagregator.network.RssItem
import kotlinx.android.synthetic.main.news_item.view.*

class NewsAdapter(var news: List<RssItem>, var callBackLink: CallBackLink) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.title
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
    }

    override fun getItemCount(): Int = news.size
}