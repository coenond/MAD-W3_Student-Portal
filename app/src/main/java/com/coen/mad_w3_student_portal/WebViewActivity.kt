package com.coen.mad_w3_student_portal

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebViewClient
import com.coen.mad_w3_student_portal.model.Portal
import kotlinx.android.synthetic.main.web_view.*

class WebViewActivity : AppCompatActivity() {

    lateinit var portal : Portal

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.web_view)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        portal = intent.getSerializableExtra("portal") as Portal

        web_frame.webViewClient = WebViewClient()
        web_frame.loadUrl(portal.url)
    }
}