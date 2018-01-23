package com.example.myapplication.data.local

import com.example.myapplication.data.DataSource
import com.example.myapplication.data.entities.Card
import io.reactivex.Maybe
import io.reactivex.Single

/**
 * Created by evin on 1/22/18.
 */

class LocalDataSource : DataSource {
  override fun getCards(): Single<List<Card>> {
    return Single.never()
  }

  override fun saveCards(cards: List<Card>): Maybe<Boolean> {
    return Maybe.never()
  }
}