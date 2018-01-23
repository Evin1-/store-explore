package com.example.myapplication.ui.main

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.example.myapplication.BR
import com.example.myapplication.R
import com.example.myapplication.base.BaseActivity
import com.example.myapplication.databinding.ActivityHomeBinding
import com.example.myapplication.di.MainComponent
import com.example.myapplication.ui.main.di.DaggerHomeComponent
import com.example.myapplication.util.ViewModelProviderFactory
import javax.inject.Inject

class HomeActivity : BaseActivity<ActivityHomeBinding, HomeViewModel>(), HomeContract.View {

  @Inject
  lateinit var viewModelFactory: ViewModelProvider.Factory

  override val bindingVariable: Int
    get() = BR.viewModel

  override val layoutId: Int
    get() = R.layout.activity_home

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    subscribeToLiveData()
  }

  override fun onStart() {
    super.onStart()
    viewModel.loadData()
  }

  override fun injectDependencies(mainComponent: MainComponent?) {
    DaggerHomeComponent.builder()
        .mainComponent(mainComponent)
        .build()
        .inject(this)
  }

  override fun setViewModel() {
    viewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)
  }

  override fun subscribeToLiveData() {
    viewModel.getLiveDataList()
        .observe(this, Observer { viewModel.setLiveDataList(it) })
  }

  override fun showError(error: String) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun showProgress() {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun hideProgress() {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

}
