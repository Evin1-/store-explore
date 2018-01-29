package com.example.myapplication.ui.home

import android.view.View
import com.example.myapplication.BuildConfig
import kotlinx.android.synthetic.main.activity_home.*
import org.hamcrest.Matchers.equalTo
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowToast


/**
 * Created by user on 1/23/18.
 */
@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class)
class HomeActivityTest {

  private var homeActivity: HomeActivity? = null

  @Before
  @Throws(Exception::class)
  fun setUp() {
    homeActivity = Robolectric.setupActivity(HomeActivity::class.java)
  }

  @After
  @Throws(Exception::class)
  fun tearDown() {
    homeActivity = null
  }

  @Test
  @Throws(Exception::class)
  fun `errorHappened_shouldSeeToastWithError`() {
    val error = "Something went wrong!"

    homeActivity?.showError(error)

    assertThat(ShadowToast.getTextOfLatestToast(), equalTo(error))
  }

  @Test
  @Throws(Exception::class)
  fun `showProgressBar_progressBarShouldBeVisible`() {
    homeActivity?.showProgress()

    assertThat(homeActivity?.a_main_progress?.visibility, equalTo(View.VISIBLE));
  }

  @Test
  @Throws(Exception::class)
  fun `hideProgress_progressBarShouldBeInvisible`() {
    homeActivity?.showProgress()

    homeActivity?.hideProgress()

    assertThat(homeActivity?.a_main_progress?.visibility, equalTo(View.INVISIBLE))
  }
}
