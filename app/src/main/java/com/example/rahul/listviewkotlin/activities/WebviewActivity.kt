package com.example.rahul.listviewkotlin.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.example.rahul.listviewkotlin.R
import kotlinx.android.synthetic.main.activity_webview.*
import android.webkit.WebView
import android.graphics.Bitmap
import android.view.View


class WebviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)

        initWebview()
    }

    fun initWebview() {
        val link = intent.getStringExtra("Link")
        main_webview.settings.javaScriptEnabled = true
        main_webview.settings.loadWithOverviewMode = true
        main_webview.settings.useWideViewPort = true

        main_webview.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                progressBar.visibility = View.VISIBLE
            }

            override fun onPageFinished(view: WebView, url: String) {

                progressBar.visibility = View.GONE
            }
        }
        main_webview.loadUrl(link)
    }
}

