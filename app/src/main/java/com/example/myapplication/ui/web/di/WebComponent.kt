package com.example.myapplication.ui.home.di

import com.example.myapplication.di.MainComponent
import com.example.myapplication.di.scopes.PerView
import com.example.myapplication.ui.web.WebActivity
import dagger.Component

/**
 * Created by evin on 1/23/18.
 */
@PerView
@Component(dependencies = arrayOf(MainComponent::class), modules = arrayOf(WebModule::class))
interface WebComponent {
  fun inject(webActivity: WebActivity)
}