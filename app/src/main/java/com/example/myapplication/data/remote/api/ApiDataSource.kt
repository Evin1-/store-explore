package com.example.myapplication.data.remote.api

import com.example.myapplication.data.DataSource
import com.example.myapplication.data.entities.Card
import io.reactivex.Maybe
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by evin on 1/22/18.
 */
class ApiDataSource @Inject constructor(private val abercrombieService: AbercrombieService) : DataSource {
  override fun getCards(): Single<List<Card>> {
    return abercrombieService.retrieveCards();
  }

  override fun saveCards(cards: List<Card>): Maybe<Boolean> {
    return Maybe.never()
  }
}