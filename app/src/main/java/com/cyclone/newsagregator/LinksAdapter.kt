package com.cyclone.newsagregator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.bottom_link_item.view.*

class LinksAdapter(private var links: ArrayList<Link>): RecyclerView.Adapter<LinksAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val linkName = itemView.link_name
        val switcher = itemView.switcher
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.bottom_link_item, parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.linkName.text = links[position].name
        holder.switcher.isChecked = links[position].isEnable
    }

    override fun getItemCount() = links.size


}