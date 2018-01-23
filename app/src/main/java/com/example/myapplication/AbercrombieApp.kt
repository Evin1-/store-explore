package com.example.myapplication

import android.app.Application
import com.example.myapplication.di.DaggerMainComponent
import com.example.myapplication.di.DomainModule
import com.example.myapplication.di.MainComponent
import com.example.myapplication.di.RxModule
import com.example.myapplication.util.AppLogger

/**
 * Created by evin on 1/22/18.
 */

class AbercrombieApp : Application() {

  var mainComponent: MainComponent? = null
    private set

  override fun onCreate() {
    super.onCreate()

    AppLogger.init()

    mainComponent = DaggerMainComponent.builder()
        .domainModule(DomainModule())
        .rxModule(RxModule())
        .build()
  }
}
