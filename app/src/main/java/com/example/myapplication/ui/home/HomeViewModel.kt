package com.example.myapplication.ui.home

import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableArrayList
import com.example.myapplication.base.BaseViewModel
import com.example.myapplication.data.DataRepository
import com.example.myapplication.data.entities.Card
import com.example.myapplication.util.AppLogger
import com.example.myapplication.util.rx.SchedulerProvider
import javax.inject.Inject

/**
 * Created by evin on 1/23/18.
 */

class HomeViewModel @Inject constructor(private val dataRepository: DataRepository,
                                        private val schedulerProvider: SchedulerProvider) : BaseViewModel(), HomeContract.ViewModel {

  val questionDataList = ObservableArrayList<Card>()
  private val questionCardData: MutableLiveData<List<Card>> = MutableLiveData()
  private val error: MutableLiveData<String> = MutableLiveData()

  override fun loadData() {
    val disposable = dataRepository.getCards()
        .subscribeOn(schedulerProvider.io())
        .observeOn(schedulerProvider.ui())
        .subscribe({ questionCardData.value = it }, { errorDownloading(it) })

    compositeDisposable.add(disposable)
  }

  override fun getLiveDataList(): MutableLiveData<List<Card>> {
    return questionCardData
  }

  override fun setLiveDataList(cardLiveData: List<Card>?) {
    questionDataList.clear()
    questionDataList.addAll(cardLiveData ?: emptyList())
  }

  private fun errorDownloading(it: Throwable) {
    questionCardData.value = emptyList()
    error.value = "Couldn't download data!"
    AppLogger.d(it.localizedMessage)
  }

  override fun getErrorMessage(): MutableLiveData<String> {
    return error
  }
}
