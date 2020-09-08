package com.cyclone.newsagregator.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.cyclone.newsagregator.R
import com.cyclone.newsagregator.adapter.LinksAdapter
import com.cyclone.newsagregator.entities.Link
import com.cyclone.newsagregator.getEnabledLinksArray
import com.cyclone.newsagregator.network.CallBackLink
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.bottom_sheet.*

class MainActivity : AppCompatActivity() {

    private lateinit var newsFragment: NewsPagerFragment

    private var links = arrayListOf(
        Link("4PDA", true, "4pda.ru"),
        Link("Habr", true, "habr.com/ru/rss/"),
        Link("SSAU", false, "ssau.ru")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val callBackLink = object : CallBackLink {
            override fun openLink(url: String) {
                val intent = Intent(this@MainActivity, WebViewFragment::class.java).apply {
                    putExtra("link", url)
                }
                startActivity(intent)
            }
        }

        val bottomSheetBehavior = BottomSheetBehavior.from(layout_bottom_sheet)
        bottomSheetBehavior.isHideable = false
        bottomSheetBehavior.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                        update()
                    }
                    else -> {

                    }
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {

            }
        })

        links_recycler.adapter = LinksAdapter(links)
        newsFragment = NewsPagerFragment(links, callBackLink)

        supportFragmentManager.beginTransaction().replace(R.id.fragment, newsFragment).commit()
    }

    fun update() {
        newsFragment.update(links.getEnabledLinksArray())
    }
}