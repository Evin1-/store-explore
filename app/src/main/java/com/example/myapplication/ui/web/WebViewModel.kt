package com.example.myapplication.ui.web

import android.databinding.ObservableField
import com.example.myapplication.base.BaseViewModel
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