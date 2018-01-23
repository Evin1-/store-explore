package com.example.myapplication.data

import com.example.myapplication.data.entities.Card
import io.reactivex.Maybe
import io.reactivex.Single

/**
 * Created by evin on 1/22/18.
 */

interface DataSource {
  fun getCards(): Single<List<Card>>
  fun saveCards(cards: List<Card>): Maybe<Boolean>
}
