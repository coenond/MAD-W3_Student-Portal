package com.coen.mad_w3_student_portal

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.webkit.WebView
import com.coen.mad_w3_student_portal.model.Portal

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var portals = ArrayList<Portal>()
    var portalAdapter = PortalAdapter({portal -> onPortalClick(portal)}, portals, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        portals.add(Portal("Google", "https://google.com/"))
        portals.add(Portal("MAD", "http://android-development.app"))

        rv_portals.adapter = portalAdapter

        fab.setOnClickListener {
            val intent = Intent(this, AddPortalActivity::class.java)
            startActivityForResult(intent, 200)
        }
    }

    private fun addPortal(portal: Portal) {
        portals.add(portal)
        portalAdapter.update(portals)
        Snackbar.make(toolbar_title, "Portal ${portal.title} added.", Snackbar.LENGTH_LONG)
                .setAction("Undo", null).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 200) {
            val portal = data?.getSerializableExtra("portal") as Portal
            addPortal(portal)
        }
    }

    private fun onPortalClick(portal: Portal) {
        val intent = Intent(this, WebViewActivity::class.java)
        intent.putExtra("portal", portal)
        startActivity(intent)
    }
}
