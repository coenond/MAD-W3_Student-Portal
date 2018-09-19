package com.coen.mad_w3_student_portal

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.add_portal_activity.*

class AddPortalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_portal_activity)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
