package com.example.resturantsapplication.di.network

import com.example.resturantsapplication.data.model.foodmodel.Food
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET

interface RestaurantService {

  @GET("task/menu.json")
  suspend fun requestGetFoods(): ApiResponse<List<Food>>

}
