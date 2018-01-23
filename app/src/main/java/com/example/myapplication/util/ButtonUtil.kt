package com.example.myapplication.util

import android.content.Context
import android.net.Uri
import android.support.customtabs.CustomTabsIntent
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import com.example.myapplication.R

/**
 * Created by user on 1/23/18.
 */
object ButtonUtil {

  fun createButton(linearLayout: LinearLayout, title: String?, target: String?): Button {
    val context = linearLayout.context
    val view: Button = LayoutInflater.from(context)
        .inflate(R.layout.button_content, linearLayout, false) as Button;
    view.text = title;
    view.setOnClickListener { showCustomChromeTabs(context, target) }

    return view
  }

  private fun showCustomChromeTabs(target: Context, url: String?) {
    val builder = CustomTabsIntent.Builder()
    val customTabsIntent = builder.build()
    customTabsIntent.launchUrl(target, Uri.parse(url))
  }
}