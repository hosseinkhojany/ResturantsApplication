package com.example.resturantsapplication.di

import com.example.resturantsapplication.data.repositories.RestaurantRepo
import com.example.resturantsapplication.di.network.RestaurantClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

  @Provides
  @ViewModelScoped
  fun provideMainRepository(
    restaurantClient: RestaurantClient,
  ): RestaurantRepo {
    return RestaurantRepo(restaurantClient)
  }

}
