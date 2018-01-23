package com.example.myapplication.util.rx

import io.reactivex.Scheduler

/**
 * Created by evin on 01/22/18.
 */

interface SchedulerProvider {
  fun ui(): Scheduler
  fun computation(): Scheduler
  fun io(): Scheduler
}
