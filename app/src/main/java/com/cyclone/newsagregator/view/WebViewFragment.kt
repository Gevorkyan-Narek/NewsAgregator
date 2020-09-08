package com.cyclone.newsagregator.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.cyclone.newsagregator.R
import kotlinx.android.synthetic.main.news_webview.*

class WebViewFragment : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.news_webview)

        val link = intent.extras?.getString("link")

        if (link != null)
            Log.d("link", link)
        else
            Log.d("link", "empty")


        webView.settings.javaScriptEnabled = true
        webView.loadUrl(link)
        webView.webViewClient = WebViewClient()
    }
}