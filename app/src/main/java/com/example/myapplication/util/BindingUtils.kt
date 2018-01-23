package com.example.myapplication.util

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import com.example.myapplication.data.entities.Card
import com.example.myapplication.ui.card.CardAdapter
import java.util.ArrayList

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
}