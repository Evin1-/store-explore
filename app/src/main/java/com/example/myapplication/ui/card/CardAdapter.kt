package com.example.myapplication.ui.card

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.data.entities.Card
import com.example.myapplication.databinding.ItemCardBinding
import android.view.LayoutInflater


/**
 * Created by evin on 1/23/18.
 */

class CardAdapter(private val listCards: MutableList<Card>) : RecyclerView.Adapter<CardAdapter.ViewHolder>() {

  override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
    val cardViewModel = listCards[position]
    holder?.bind(cardViewModel)
  }

  override fun getItemCount(): Int {
    return listCards.size
  }

  override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
    val layoutInflater = LayoutInflater.from(parent?.context)
    val itemBinding: ItemCardBinding = ItemCardBinding.inflate(layoutInflater, parent, false)
    return ViewHolder(itemBinding)
  }

  class ViewHolder(private val itemBinding: ItemCardBinding) : RecyclerView.ViewHolder(itemBinding.root) {
    fun bind(card: Card) {
      itemBinding.viewModel = CardViewModel.of(card)
      itemBinding.executePendingBindings()
    }
  }

  fun updateItems(cards: List<Card>) {
    listCards.clear()
    listCards.addAll(cards)
    notifyDataSetChanged()
  }
}