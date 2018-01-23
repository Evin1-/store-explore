package com.example.myapplication.ui.main.di

import com.example.myapplication.di.MainComponent
import com.example.myapplication.di.scopes.PerView
import com.example.myapplication.ui.main.HomeActivity
import dagger.Component

/**
 * Created by evin on 1/23/18.
 */
@PerView
@Component(dependencies = arrayOf(MainComponent::class), modules = arrayOf(HomeModule::class))
interface HomeComponent {
  fun inject(homeActivity: HomeActivity)
}