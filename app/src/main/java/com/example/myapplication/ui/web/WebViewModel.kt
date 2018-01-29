package com.example.myapplication.ui.web

import android.databinding.Bindable
import android.databinding.Observable
import android.databinding.ObservableField
import com.android.databinding.library.baseAdapters.BR
import com.example.myapplication.base.BaseViewModel
import com.example.myapplication.util.AppLogger
import javax.inject.Inject

/**
 * Created by evin on 1/29/18.
 */

class WebViewModel @Inject constructor() : BaseViewModel(), WebContract.ViewModel {
  val url = ObservableField<String>()

  override fun setUrl(string: String) {
    url.set(string)
  }
}