package com.example.myapplication.ui.main.di

import android.arch.lifecycle.ViewModelProvider
import com.example.myapplication.di.scopes.PerView
import com.example.myapplication.ui.main.HomeViewModel
import com.example.myapplication.util.ViewModelProviderFactory
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
    return ViewModelProviderFactory<HomeViewModel>(homeViewModel)
  }
}