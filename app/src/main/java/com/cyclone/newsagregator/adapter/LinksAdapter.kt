package com.cyclone.newsagregator.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cyclone.newsagregator.R
import com.cyclone.newsagregator.entities.Link
import com.google.android.material.switchmaterial.SwitchMaterial
import kotlinx.android.synthetic.main.bottom_link_item.view.*

class LinksAdapter(private var links: ArrayList<Link>) :
    RecyclerView.Adapter<LinksAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val linkName: TextView = itemView.link_name
        val switcher: SwitchMaterial = itemView.switcher
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.bottom_link_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.linkName.text = links[position].name
        holder.switcher.isChecked = links[position].isEnable
        holder.switcher.setOnCheckedChangeListener { _, isChecked ->
            links[position].isEnable = isChecked
        }
    }

    override fun getItemCount() = links.size
}