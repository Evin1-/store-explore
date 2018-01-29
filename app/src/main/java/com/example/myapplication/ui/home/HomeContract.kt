package com.example.myapplication.ui.home

import android.arch.lifecycle.MutableLiveData
import com.example.myapplication.data.entities.Card

/**
 * Created by evin on 1/23/18.
 */
interface HomeContract {
  interface View {
    fun subscribeToLiveData()
    fun showError(error: String?)
    fun showProgress()
    fun hideProgress()
  }

  interface ViewModel {
    fun getLiveDataList(): MutableLiveData<List<Card>>
    fun setLiveDataList(cardLiveData: List<Card>?)
    fun getErrorMessage(): MutableLiveData<String>
    fun loadData()
  }
}
