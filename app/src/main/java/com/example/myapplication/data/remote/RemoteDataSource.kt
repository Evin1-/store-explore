package com.example.myapplication.data.remote

import com.example.myapplication.data.DataSource
import com.example.myapplication.data.entities.Card
import com.example.myapplication.data.remote.api.AbercrombieService
import com.example.myapplication.util.rx.SchedulerProvider
import io.reactivex.Maybe
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by evin on 1/22/18.
 */
class RemoteDataSource @Inject constructor(private val abercrombieService: AbercrombieService) : DataSource {
  override fun getCards(): Single<List<Card>> {
    return abercrombieService.retrieveCards()
  }

  override fun saveCards(cards: List<Card>): Maybe<Boolean> {
    return Maybe.never()
  }
}