package com.example.myapplication.base

import android.arch.lifecycle.ViewModel
import com.example.myapplication.data.DataSource
import com.example.myapplication.util.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by evin on 1/23/18.
 */
abstract class BaseViewModel : ViewModel() {

  private val compositeDisposable = CompositeDisposable()

  override fun onCleared() {
    super.onCleared()
    compositeDisposable.dispose()
  }
}