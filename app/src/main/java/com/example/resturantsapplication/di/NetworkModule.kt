package com.example.resturantsapplication.di

import com.example.resturantsapplication.di.network.HttpRequestInterceptor
import com.example.resturantsapplication.di.network.RestaurantClient
import com.example.resturantsapplication.di.network.RestaurantService
import com.skydoves.sandwich.coroutines.CoroutinesResponseCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

  @Provides
  @Singleton
  fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
      .addInterceptor(HttpRequestInterceptor())
      .build()
  }

  @Provides
  @Singleton
  fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
      .client(okHttpClient)
      .baseUrl("https://cdn.opeqe.com/")
      .addConverterFactory(MoshiConverterFactory.create())
      .addCallAdapterFactory(CoroutinesResponseCallAdapterFactory())
      .build()
  }

  @Provides
  @Singleton
  fun providePokedexService(retrofit: Retrofit): RestaurantService {
    return retrofit.create(RestaurantService::class.java)
  }

  @Provides
  @Singleton
  fun providePokedexClient(pokedexService: RestaurantService): RestaurantClient {
    return RestaurantClient(pokedexService)
  }
}
