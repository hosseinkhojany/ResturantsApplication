package com.example.resturantsapplication.di.network

import com.example.resturantsapplication.data.model.foodmodel.Food
import com.skydoves.sandwich.ApiResponse
import javax.inject.Inject

class RestaurantClient @Inject constructor(
  private val restaurantService: RestaurantService
) {

  suspend fun fetchFoods(): ApiResponse<List<Food>> =
    restaurantService.requestGetFoods()

}
