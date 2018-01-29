package com.example.myapplication.ui.web

/**
 * Created by evin on 1/29/18.
 */
interface WebContract {
  interface View

  interface ViewModel {
    fun setUrl(string: String)
  }
}