package com.example.myapplication.di

import com.example.myapplication.data.DataRepository
import com.example.myapplication.util.rx.SchedulerProvider
import dagger.Component
import javax.inject.Singleton

/**
 * Created by evin on 1/22/18.
 */
@Singleton
@Component(modules = arrayOf(DomainModule::class, RxModule::class))
interface MainComponent {
  fun dataRepository(): DataRepository
  fun schedulerProvider(): SchedulerProvider
}