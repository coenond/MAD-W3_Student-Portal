package com.coen.mad_w3_student_portal.model

import android.webkit.URLUtil

class Portal(t: String, u: String) {
    val title: String = t
    val url: String = u

    fun checkUrl(url: String): Boolean {
        return URLUtil.isValidUrl(url)
    }
}