package com.example.myapplication.ui.home

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.myapplication.BR
import com.example.myapplication.R
import com.example.myapplication.base.BaseActivity
import com.example.myapplication.databinding.ActivityHomeBinding
import com.example.myapplication.di.MainComponent
import com.example.myapplication.ui.card.CardAdapter
import com.example.myapplication.ui.home.di.DaggerHomeComponent
import javax.inject.Inject

class HomeActivity : BaseActivity<ActivityHomeBinding, HomeViewModel>(), HomeContract.View {

  @Inject
  lateinit var viewModelFactory: ViewModelProvider.Factory

  @Inject
  lateinit var cardAdapter: CardAdapter

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
    setup()
    viewModel.loadData()
  }

  private fun setup() {
    viewDataBinding.aMainRecycler.adapter = cardAdapter
    viewDataBinding.aMainRecycler.layoutManager = LinearLayoutManager(this)
    viewDataBinding.aMainRecycler.itemAnimator = DefaultItemAnimator()
    viewDataBinding.aMainRecycler.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
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
