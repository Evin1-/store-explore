package com.example.myapplication.base

import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by evin on 1/23/18.
 */
abstract class BaseViewModel : ViewModel() {

  protected val compositeDisposable = CompositeDisposable()

  override fun onCleared() {
    super.onCleared()
    compositeDisposable.dispose()
  }
}