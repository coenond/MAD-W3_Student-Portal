package com.coen.mad_w3_student_portal

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager
import com.coen.mad_w3_student_portal.model.Portal
import kotlinx.android.synthetic.main.add_portal_activity.*

class AddPortalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_portal_activity)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btn_submit.setOnClickListener {
            closeKeyboard()
            hanleSubmit()
        }
    }

    private fun hanleSubmit() {
        val title: TextInputEditText = et_title
        val url: TextInputEditText = et_url

        val portal = Portal(title.text.toString(), url.text.toString())

        val intent = Intent()
        intent.putExtra("portal", portal)
        setResult(200, intent)
        finish()
    }

    private fun closeKeyboard() {
        val inputManager: InputMethodManager =getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(currentFocus.windowToken, InputMethodManager.SHOW_FORCED)
    }
}
