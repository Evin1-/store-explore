package com.example.myapplication.di

import com.example.myapplication.util.rx.AppSchedulerProvider
import com.example.myapplication.util.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by evin on 1/22/18.
 */

@Module
class RxModule {

  @Singleton
  @Provides
  fun createSchedulerProvider(): SchedulerProvider {
    return AppSchedulerProvider
  }
}