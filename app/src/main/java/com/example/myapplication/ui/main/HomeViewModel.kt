package com.example.myapplication.ui.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableArrayList
import com.example.myapplication.base.BaseViewModel
import com.example.myapplication.data.DataRepository
import com.example.myapplication.data.entities.Card
import com.example.myapplication.util.AppLogger
import com.example.myapplication.util.rx.SchedulerProvider
import io.reactivex.functions.Consumer
import javax.inject.Inject

/**
 * Created by evin on 1/23/18.
 */

class HomeViewModel @Inject constructor(private val dataRepository: DataRepository,
                                        private val schedulerProvider: SchedulerProvider) : BaseViewModel(), HomeContract.ViewModel {

  private val questionDataList = ObservableArrayList<Card>()
  private val questionCardData: MutableLiveData<List<Card>> = MutableLiveData()

  override fun loadData() {
    dataRepository.getCards()
        .subscribeOn(schedulerProvider.io())
        .observeOn(schedulerProvider.ui())
        .subscribe(Consumer { questionCardData.value = it })
  }

  override fun getLiveDataList(): MutableLiveData<List<Card>> {
    return questionCardData
  }

  override fun setLiveDataList(cardLiveData: List<Card>?) {
    AppLogger.d(cardLiveData.toString())
    questionDataList.clear()
    questionDataList.addAll(cardLiveData ?: emptyList())
  }
}
