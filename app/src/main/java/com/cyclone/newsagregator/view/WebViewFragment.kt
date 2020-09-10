package com.cyclone.newsagregator.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.cyclone.newsagregator.R
import kotlinx.android.synthetic.main.news_webview.*

class WebViewFragment : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.news_webview)

        webView.webViewClient = WebViewClient()
        webView.webChromeClient = WebChromeClient()
        val link = intent.extras?.getString("link")
        webView.settings.javaScriptEnabled = true

        if (link != null)
            webView.loadUrl(link)
        else
            webView.loadData("<html><body>Error</body></html>", "text/html", "UTF-8")

    }
}