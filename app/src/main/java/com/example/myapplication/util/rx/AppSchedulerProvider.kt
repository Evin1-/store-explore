package com.example.myapplication.util.rx

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by evin on 01/22/18.
 */

object AppSchedulerProvider : SchedulerProvider {
  override fun ui(): Scheduler = AndroidSchedulers.mainThread()
  override fun computation(): Scheduler = Schedulers.computation()
  override fun io(): Scheduler = Schedulers.io()
}
