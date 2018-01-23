package com.example.myapplication.di

import com.example.myapplication.data.local.LocalDataSource
import com.example.myapplication.data.remote.RemoteDataSource
import com.example.myapplication.data.remote.api.AbercrombieService
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by evin on 1/22/18.
 */

@Module
class DomainModule {

  @Singleton
  @Provides
  fun createLocalDataSource(): LocalDataSource {
    return LocalDataSource()
  }

  @Singleton
  @Provides
  fun createRemoteDataSource(abercrombieService: AbercrombieService): RemoteDataSource {
    return RemoteDataSource(abercrombieService)
  }

  @Singleton
  @Provides
  fun createInterceptor(): Interceptor {
    return AbercrombieService.Factory.createApiInterceptor()
  }

  @Singleton
  @Provides
  fun createOkHttpClient(interceptor: Interceptor): OkHttpClient {
    return AbercrombieService.Factory.createOkHttp(interceptor)
  }

  @Singleton
  @Provides
  fun createRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return AbercrombieService.Factory.createRetrofit(okHttpClient)
  }

  @Singleton
  @Provides
  fun createAbercrombieService(retrofit: Retrofit): AbercrombieService {
    return AbercrombieService.Factory.createApiService(retrofit)
  }
}