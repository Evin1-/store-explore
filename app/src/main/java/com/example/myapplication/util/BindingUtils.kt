package com.example.myapplication.util

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import android.widget.LinearLayout
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
  fun setImageUrl(linearLayout: LinearLayout, content: List<Content>) {
    // TODO: Optimize with ViewHolder
    linearLayout.removeAllViews()
    content.forEach {
      linearLayout.addView(ButtonUtil.createButton(linearLayout, it.title, it.target))
    }
  }
}