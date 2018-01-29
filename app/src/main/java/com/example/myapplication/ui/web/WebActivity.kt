package com.example.myapplication.ui.web

import android.annotation.SuppressLint
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.myapplication.BR
import com.example.myapplication.R
import com.example.myapplication.base.BaseActivity
import com.example.myapplication.databinding.ActivityWebBinding
import com.example.myapplication.di.MainComponent
import com.example.myapplication.ui.home.di.DaggerWebComponent
import com.example.myapplication.util.AppLogger
import com.example.myapplication.util.IntentUtils.parseIncomingIntent
import javax.inject.Inject

/**
 * Created by evin on 1/29/18.
 */

class WebActivity : BaseActivity<ActivityWebBinding, WebViewModel>() {

  companion object {
    val URL_BUNDLE_KEY = "URL_BUNDLE_KEY"

    fun getIntent(context: Context, url: String): Intent {
      val intent = Intent(context, WebActivity::class.java)
      intent.putExtra(URL_BUNDLE_KEY, url)
      return intent
    }
  }

  @Inject
  lateinit var viewModelFactory: ViewModelProvider.Factory

  override val layoutId: Int
    get() = R.layout.activity_web
  override val bindingVariable: Int
    get() = BR.viewModel

  @SuppressLint("SetJavaScriptEnabled")
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    viewDataBinding.aWebView.settings.javaScriptEnabled = true
    viewDataBinding.aWebView.webViewClient = object : WebViewClient() {
      override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
        // TODO 1/29: Update with shouldOverrideUrlLoading(webView, UrlRequest)
        view?.loadUrl(url)
        return true
      }
    }
  }

  override fun onStart() {
    super.onStart()
    viewModel.setUrl(parseIncomingIntent(intent))
  }

  override fun injectDependencies(mainComponent: MainComponent?) {
    DaggerWebComponent.builder()
        .mainComponent(mainComponent)
        .build()
        .inject(this)
  }

  override fun setViewModel() {
    viewModel = ViewModelProviders.of(this, viewModelFactory).get(WebViewModel::class.java)
  }

}
