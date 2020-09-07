package com.cyclone.newsagregator.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.cyclone.newsagregator.R
import com.cyclone.newsagregator.entities.Link
import com.cyclone.newsagregator.getEnabledLinksArray
import com.cyclone.newsagregator.setAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.news_pager_fragment.*

class NewsPagerFragment(links: ArrayList<Link>) :
    Fragment(R.layout.news_pager_fragment) {

    private lateinit var mediator: TabLayoutMediator
    private var enabledLinks = links.getEnabledLinksArray()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        pager.setAdapter(this, enabledLinks)
        mediator = TabLayoutMediator(tabLayout, pager) { tab, position ->
            tab.text = enabledLinks[position].name
        }
        mediator.attach()
    }

    fun update(links: ArrayList<Link>) {
        mediator.detach()
        enabledLinks = links
        pager.setAdapter(this, enabledLinks)
        mediator.attach()
    }
}