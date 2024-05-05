package com.atustudentsafternoon

import android.os.Bundle
import android.webkit.WebView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WebViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        webview()
    }


    private fun webview(){
        val webview: WebView = findViewById(R.id.my_webview)
        webview.loadUrl("https://abaarsotechuniversity.org/")
    }

}