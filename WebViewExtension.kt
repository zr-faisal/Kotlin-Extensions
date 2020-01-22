package com.ihis.foj.utils

import android.annotation.SuppressLint
import android.net.http.SslError
import android.util.Log
import android.webkit.SslErrorHandler
import android.webkit.WebView
import android.webkit.WebViewClient

/**
 * Sets up WebViewClient to handle urls loading and ignore SSL warnings
 */
@SuppressLint("SetJavaScriptEnabled")
fun WebView.setupHandler() {
    // Init WebView
    webViewClient = object : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            view?.loadUrl(url)
            return true
        }

        override fun onReceivedSslError(
            view: WebView?,
            handler: SslErrorHandler,
            error: SslError?
        ) {
            // Ignore SSL certificate errors
            Log.d("onReceivedSslError", error.toString())
            handler.proceed()
        }
    }
    settings.javaScriptEnabled = true
    settings.javaScriptCanOpenWindowsAutomatically = true
}
