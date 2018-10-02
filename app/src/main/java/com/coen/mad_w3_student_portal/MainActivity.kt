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

        fab.setOnClickListener {
            val intent = Intent(this, AddPortalActivity::class.java)
            startActivityForResult(intent, 200)
        }
    }

    private fun addPortal(portal: Portal) {
        portals.add(portal)

        println("size " + portals.size)

        for (portal in portals) {
            println(portal)
        }

        Snackbar.make(toolbar_title, "Portal $title added.", Snackbar.LENGTH_LONG)
                .setAction("Undo", null).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)

        println("onactivityresult: $resultCode | $requestCode")

        if (requestCode == 200) {
            val portal = data?.getSerializableExtra("portal") as Portal
            addPortal(portal)
        }
    }
}
