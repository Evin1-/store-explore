package com.example.myapplication.ui.home

import android.support.annotation.NonNull
import com.example.myapplication.data.DataRepository
import com.example.myapplication.data.entities.Card
import com.example.myapplication.util.AppLogger
import com.example.myapplication.util.rx.SchedulerProvider
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.robolectric.Robolectric
import java.util.*
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.disposables.Disposable
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.internal.schedulers.ExecutorScheduler
import org.junit.BeforeClass
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit


/**
 * Created by user on 1/23/18.
 */
// TODO: Set fake Dagger providers for the injection
class HomeViewModelTest {
  private var homeViewModel: HomeViewModel? = null
  private val dataRepository = mock<DataRepository> {
    on { getCards() } doReturn (Single.just(Arrays.asList()))
  }

  private val schedulerProvider = mock<SchedulerProvider> {
    on { ui() } doReturn (Schedulers.trampoline())
    on { io() } doReturn (Schedulers.trampoline())
  }

  @Before
  @Throws(Exception::class)
  fun setUp() {
    homeViewModel = HomeViewModel(dataRepository, schedulerProvider)
  }

  @After
  @Throws(Exception::class)
  fun tearDown() {
    homeViewModel = null
  }

  @Test
  fun `onLoadData_shouldGetInformationFromWebServer`() {
    homeViewModel?.loadData()

    verify(dataRepository).getCards()
  }
}