package com.cyclone.newsagregator.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.cyclone.newsagregator.adapter.NewsPagerAdapter
import com.cyclone.newsagregator.R
import kotlinx.android.synthetic.main.news_item.*

class NewsObjectFragment : Fragment(R.layout.news_item) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.takeIf {
            it.containsKey(NewsPagerAdapter.CURRENT_TAB)
        }?.apply {
            newsName.text = getString(NewsPagerAdapter.CURRENT_TAB)
        }
    }
}