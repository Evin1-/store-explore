package com.example.myapplication.ui.card

import android.databinding.ObservableArrayList
import android.databinding.ObservableField
import com.example.myapplication.data.entities.Card
import com.example.myapplication.data.entities.Content

/**
 * Created by evin on 1/23/18.
 */

class CardViewModel(title: String?, backgroundImage: String?, topDescription: String?,
                    promoMessage: String?, bottomDescription: String?, content: List<Content>?) {
  val title = ObservableField<String>()
  val backgroundImage = ObservableField<String>()
  val topDescription = ObservableField<String>()
  val promoMessage = ObservableField<String>()
  val bottomDescription = ObservableField<String>()
  val content = ObservableArrayList<Content>()

  init {
    this.title.set(title ?: "")
    this.backgroundImage.set(backgroundImage ?: "")
    this.topDescription.set(topDescription ?: "")
    this.promoMessage.set(promoMessage ?: "")
    this.bottomDescription.set(bottomDescription ?: "")
    this.content.clear()
    this.content.addAll(content ?: emptyList())
  }

  companion object {
    fun of(card: Card): CardViewModel {
      return CardViewModel(card.title, card.backgroundImage, card.topDescription, card.promoMessage, card.bottomDescription, card.content)
    }
  }
}