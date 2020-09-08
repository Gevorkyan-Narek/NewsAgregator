package com.cyclone.newsagregator

import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.cyclone.newsagregator.adapter.NewsPagerAdapter
import com.cyclone.newsagregator.entities.Link
import com.cyclone.newsagregator.network.CallBackLink

fun ArrayList<Link>.getEnabledLinksArray() = filter { link -> link.isEnable } as ArrayList<Link>

fun ViewPager2.setAdapter(fragment: Fragment, enabledLinks: ArrayList<Link>, callBack: CallBackLink) {
    adapter = NewsPagerAdapter(fragment, enabledLinks, callBack)
}