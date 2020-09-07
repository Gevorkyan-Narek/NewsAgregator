package com.cyclone.newsagregator.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.cyclone.newsagregator.R
import com.cyclone.newsagregator.adapter.NewsAdapter
import com.cyclone.newsagregator.adapter.NewsPagerAdapter
import com.cyclone.newsagregator.network.RssFeed
import com.cyclone.newsagregator.network.RssService
import kotlinx.android.synthetic.main.news_object_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsObjectFragment : Fragment(R.layout.news_object_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.takeIf {
            it.containsKey(NewsPagerAdapter.CURRENT_TAB)
        }?.apply {
            if (getString(NewsPagerAdapter.CURRENT_TAB) == "4PDA") {
                connect4PDA()
            }
        }
    }


    private fun connect4PDA() {
        RssService.getApi4PDA().getFeed().enqueue(object : Callback<RssFeed> {
            override fun onResponse(call: Call<RssFeed>, response: Response<RssFeed>) {
                Log.d("Response", "Start")
                if (response.isSuccessful) {
                    val body = response.body()?.channel
                    if (body != null) {
                        newsRecycler.adapter = NewsAdapter(body.item)
                        val dividerItemDecoration = DividerItemDecoration(
                            newsRecycler.context,
                            DividerItemDecoration.VERTICAL
                        )
                        newsRecycler.addItemDecoration(dividerItemDecoration)
                    }

                } else Log.d("Response", response.message())
            }

            override fun onFailure(call: Call<RssFeed>, t: Throwable) {
                Log.d("Failure", "Start")
                if (call.isCanceled) {
                    Log.d("Failure", "call was cancelled forcefully")
                } else {
                    Log.d("Failure", t.localizedMessage!!)
                    Log.d("Failure", t.suppressed.contentToString())
                    Log.d("Failure", call.request().url().toString())
                }
            }
        })
    }
}