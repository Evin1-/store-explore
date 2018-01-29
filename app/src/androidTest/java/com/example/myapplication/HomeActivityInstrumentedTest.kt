package com.example.myapplication

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import com.example.myapplication.ui.home.HomeActivity
import org.hamcrest.CoreMatchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by evin on 1/23/18.
 */

@RunWith(AndroidJUnit4::class)
class HomeActivityInstrumentedTest {
  @Rule
  @JvmField
  val activity = ActivityTestRule<HomeActivity>(HomeActivity::class.java)

  @Test
  fun `onLoad_dataShouldBeSetOnRecycler`() {

    getViewFromId(R.id.a_main_recycler)
        .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
  }

  private fun getViewFromId(id: Int) = onView(withId(id))
}