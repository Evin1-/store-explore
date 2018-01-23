package com.example.myapplication.data

import com.example.myapplication.data.entities.Card
import com.example.myapplication.data.local.LocalDataSource
import com.example.myapplication.data.remote.RemoteDataSource
import com.example.myapplication.util.AppLogger
import io.reactivex.Maybe
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by evin on 1/22/18.
 */

class DataRepository @Inject constructor(private val remoteDataSource: RemoteDataSource,
                                         private val localDataSource: LocalDataSource) : DataSource {

  // TODO: Implement localDataSource cache with Room
  override fun getCards(): Single<List<Card>> {
    return remoteDataSource.getCards()
        .doOnError { AppLogger.e(it.toString()) }
  }

  override fun saveCards(cards: List<Card>): Maybe<Boolean> {
    return Maybe.never()
  }
}