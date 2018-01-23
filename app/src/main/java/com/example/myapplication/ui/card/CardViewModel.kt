package com.example.myapplication.ui.card

import android.databinding.ObservableField
import com.example.myapplication.data.entities.Card

/**
 * Created by evin on 1/23/18.
 */

class CardViewModel(title: String?, image: String?) {
  val title = ObservableField<String>()
  val image = ObservableField<String>()

  init {
    this.title.set(title ?: "")
    this.image.set(image ?: "")
  }

  companion object {
    fun of(card: Card): CardViewModel {
      return CardViewModel(card.title, card.backgroundImage)
    }
  }
}