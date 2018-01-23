package com.example.myapplication.data.remote.api

import com.example.myapplication.data.entities.Card
import io.reactivex.Single
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

/**
 * Created by evin on 1/22/18.
 */
interface AbercrombieService {
  @Headers("User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_3)")
  @GET("/anf/nativeapp/qa/codetest/codeTest_exploreData.json")
  fun retrieveCards(): Single<List<Card>>

  companion object Factory {
    private val BASE_URL = "https://www.abercrombie.com/"

    fun createApiInterceptor(): Interceptor {
      val interceptor = HttpLoggingInterceptor()
      interceptor.level = HttpLoggingInterceptor.Level.BODY
      return interceptor
    }

    fun createOkHttp(interceptor: Interceptor): OkHttpClient {
      return OkHttpClient.Builder()
          .addInterceptor(interceptor)
          .build()
    }

    fun createRetrofit(okHttpClient: OkHttpClient): Retrofit {
      return Retrofit.Builder()
          .baseUrl(BASE_URL)
          .client(okHttpClient)
          .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
          .addConverterFactory(GsonConverterFactory.create())
          .build();
    }

    fun createApiService(retrofit: Retrofit): AbercrombieService
        = retrofit.create(AbercrombieService::class.java)
  }
}