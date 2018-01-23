package com.example.myapplication.ui.home.di

import android.arch.lifecycle.ViewModelProvider
import com.example.myapplication.di.scopes.PerView
import com.example.myapplication.ui.home.HomeViewModel
import com.example.myapplication.util.ViewModelFactory
import dagger.Module
import dagger.Provides

/**
 * Created by evin on 1/23/18.
 */
@Module

class HomeModule {

  @PerView
  @Provides
  fun createViewModelFactory(homeViewModel: HomeViewModel): ViewModelProvider.Factory {
    return ViewModelFactory<HomeViewModel>(homeViewModel)
  }
}