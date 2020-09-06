package com.cyclone.newsagregator.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.cyclone.newsagregator.entities.Link
import com.cyclone.newsagregator.view.NewsObjectFragment

class NewsPagerAdapter(fragment: Fragment, private var links: ArrayList<Link>) :
    FragmentStateAdapter(fragment) {

    companion object {
        const val CURRENT_TAB = "Tab"
    }

    override fun getItemCount() = links.size

    override fun createFragment(position: Int): Fragment {
        val newsFragment = NewsObjectFragment()
        newsFragment.arguments = Bundle().apply {
            putString(CURRENT_TAB, links[position].name)
        }
        return newsFragment
    }
}