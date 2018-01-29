package com.example.myapplication.util

import android.content.Intent
import android.util.Log
import com.example.myapplication.ui.web.WebActivity

/**
 * Created by evin on 1/29/18.
 */
object IntentUtils {

  fun parseIncomingIntent(intent: Intent): String {

    val s = (intent.getStringExtra(WebActivity.URL_BUNDLE_KEY)
        ?: "https://www.abercrombie.com/shop/wd")
    AppLogger.d(s)

    Log.d("TAGTAG__", "parseIncomingIntent: ")
    return s
  }
}