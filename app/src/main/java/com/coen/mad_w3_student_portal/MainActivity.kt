package com.coen.mad_w3_student_portal

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.coen.mad_w3_student_portal.model.Portal

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var portals = ArrayList<Portal>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = intent

        if (intent.hasExtra("title") && intent.hasExtra("url")) {
            addPortal(intent)
        }

        fab.setOnClickListener {
            val intent = Intent(this, AddPortalActivity::class.java)
            intent.putExtra("portal", portals)
            startActivity(intent)
        }
    }

    private fun addPortal(intent: Intent) {
        val title = intent.getStringExtra("title")
        val url = intent.getStringExtra("url")

        portals.add(Portal(title, url))
        Snackbar.make(toolbar_title, "Portal $title added.", Snackbar.LENGTH_LONG)
                .setAction("Undo", null).show()
    }
}
