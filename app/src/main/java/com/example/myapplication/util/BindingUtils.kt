package com.example.myapplication.util

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.text.method.LinkMovementMethod
import android.view.View
import android.webkit.WebView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.myapplication.data.entities.Card
import com.example.myapplication.data.entities.Content
import com.example.myapplication.ui.card.CardAdapter

/**
 * Created by evin on 1/23/18.
 */
object BindingUtils {

  @JvmStatic
  @BindingAdapter("adapter")
  fun addCards(recyclerView: RecyclerView, cards: List<Card>) {
    val adapter = recyclerView.adapter as CardAdapter?
    adapter?.updateItems(cards)
  }

  @JvmStatic
  @BindingAdapter("imageUrl")
  fun setImageUrl(imageView: ImageView, url: String) {
    val context = imageView.context
    Glide.with(context).load(url).into(imageView)
  }

  @JvmStatic
  @BindingAdapter("actions")
  fun actions(linearLayout: LinearLayout, content: List<Content>) {
    // TODO: Optimize with ViewHolder
    linearLayout.removeAllViews()
    content.forEach {
      linearLayout.addView(ButtonUtils.createButton(linearLayout, it.title, it.target))
    }
  }

  @JvmStatic
  @BindingAdapter("emptyVisibility")
  fun emptyVisibility(textView: TextView, string: String) {
    textView.movementMethod = LinkMovementMethod.getInstance()
    when {
      string.isEmpty() -> textView.visibility = View.GONE
      else -> textView.visibility = View.VISIBLE
    }
  }

  @JvmStatic
  @BindingAdapter("setUrl")
  fun setUrl(webView: WebView, url: String?) {
    if (url != null) {
      webView.loadUrl(url)
    }
  }
}