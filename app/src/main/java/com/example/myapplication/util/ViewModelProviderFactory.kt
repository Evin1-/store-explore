package com.example.myapplication.util

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

import javax.inject.Inject

class ViewModelProviderFactory<V>(private val viewModel: V) : ViewModelProvider.Factory {

  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    return viewModel as T
  }
}
