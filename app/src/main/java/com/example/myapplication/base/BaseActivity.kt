package com.example.myapplication.base;

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.myapplication.AbercrombieApp
import com.example.myapplication.di.MainComponent

abstract class BaseActivity<T : ViewDataBinding, V : BaseViewModel> : AppCompatActivity() {

  protected abstract val layoutId: Int
  protected abstract val bindingVariable: Int

  protected lateinit var viewModel: V
  protected lateinit var mViewDataBinding: T

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layoutId)

    injectDependencies((application as AbercrombieApp).mainComponent)

    setViewModel()
    performDataBinding()
  }

  private fun performDataBinding() {
    mViewDataBinding = DataBindingUtil.setContentView<T>(this, layoutId)
    mViewDataBinding.setVariable(bindingVariable, viewModel)
    mViewDataBinding.executePendingBindings()
  }

  abstract fun injectDependencies(mainComponent: MainComponent?)
  abstract fun setViewModel()
}