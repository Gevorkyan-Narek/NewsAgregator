package com.cyclone.newsagregator.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AbsListView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cyclone.newsagregator.R
import com.cyclone.newsagregator.adapter.NewsAdapter
import com.cyclone.newsagregator.adapter.NewsPagerAdapter
import com.cyclone.newsagregator.network.*
import kotlinx.android.synthetic.main.news_object_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsObjectFragment(var callBackLink: CallBackLink) : Fragment(R.layout.news_object_fragment) {

    private lateinit var service: RSS
    private var currentPage = 1

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.takeIf {
            it.containsKey(NewsPagerAdapter.CURRENT_TAB)
        }?.apply {
            when (getString(NewsPagerAdapter.CURRENT_TAB)) {
                "4PDA" -> service = RssService.getRss4PDA()!!
                "Habr" -> service = RssService.getRssHabr()!!
            }
            service.getFeed().connect()
        }
    }

    private fun Call<RssFeed>.connect() {
        enqueue(object : Callback<RssFeed> {
            override fun onResponse(call: Call<RssFeed>, response: Response<RssFeed>) {
                if (response.isSuccessful) {
                    val body = response.body()?.channel
                    if (body != null) {
                        newsRecycler.adapter = NewsAdapter(body.item, callBackLink)
                        newsRecycler.addItemDecoration(
                            DividerItemDecoration(
                                newsRecycler.context,
                                DividerItemDecoration.VERTICAL
                            )
                        )
                        if (service !is FourPDA)
                            newsRecycler.addOnScrollListener(object :
                                RecyclerView.OnScrollListener() {
                                override fun onScrollStateChanged(
                                    recyclerView: RecyclerView,
                                    newState: Int
                                ) {
                                    super.onScrollStateChanged(recyclerView, newState)

                                    val lastItem =
                                        (recyclerView.layoutManager as LinearLayoutManager).findLastVisibleItemPosition() + 1

                                    if (lastItem == newsRecycler.adapter?.itemCount) {
                                        currentPage++
                                        Log.d("Recycler", "CurrentPage: $currentPage")
                                        service.newPage(currentPage)
                                            .changePage(recyclerView.adapter!!.itemCount)
                                    }
                                }
                            })
                    }

                } else Log.d("Response", response.message())
            }

            override fun onFailure(call: Call<RssFeed>, t: Throwable) {
                if (call.isCanceled) {
                    Log.d("Failure", "call was cancelled forcefully")
                } else {
                    Log.d("Failure", t.localizedMessage!!)
                    Log.d("Failure", call.request().url().toString())
                }
            }
        })
    }

    private fun Call<RssFeed>.changePage(position: Int) {
        enqueue(object : Callback<RssFeed> {
            override fun onResponse(call: Call<RssFeed>, response: Response<RssFeed>) {
                Log.d("Recycler", "Url: ${response.raw().request().url()}")
                if (response.isSuccessful) {
                    val body = response.body()?.channel
                    if (body != null) {
                        (newsRecycler.adapter as NewsAdapter).updateNews(body.item, position)
                    }
                } else Log.d("Response", "Error")
            }

            override fun onFailure(call: Call<RssFeed>, t: Throwable) {
                if (call.isCanceled) {
                    Log.d("Failure", "call was cancelled forcefully")
                } else {
                    Log.d("Failure", t.localizedMessage!!)
                    Log.d("Failure", call.request().url().toString())
                }
            }

        })
    }

}