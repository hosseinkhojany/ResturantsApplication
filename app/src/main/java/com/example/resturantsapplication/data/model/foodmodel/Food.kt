package com.example.resturantsapplication.data.model.foodmodel

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Food(
    @field:Json(name = "id") val id: String?,
    @field:Json(name = "title") val title: String?,
    @field:Json(name = "subTitle") val subTitle: String?,
    @field:Json(name = "description") val description: String?,
    @field:Json(name = "ingredients") val ingredients: String?,
    @field:Json(name = "minimumCalorie") val minimumCalorie: Int,
    @field:Json(name = "maximumCalorie") val maximumCalorie: Int,
    @field:Json(name = "preparation") val preparation: Int,
    @field:Json(name = "delivery") val delivery: Int,
    @field:Json(name = "image") val image: String,
    @field:Json(name = "price") val price: Float?,
    @field:Json(name = "fee") val fee: Int,
    @field:Json(name = "rate") val rate: Int,
    @field:Json(name = "isAcceptingDelivery") val isAcceptingDelivery: Boolean,
    @field:Json(name = "isAcceptingPickup") val isAcceptingPickup: Boolean,
    @field:Json(name = "isFavorite") val isFavorite: Boolean,
    @field:Json(name = "isCatering") val isCatering: Boolean,
    @field:Json(name = "isAvailable") val isAvailable: Boolean,
    @field:Json(name = "cuisineType") val cuisineType: CuisineType,
    @field:Json(name = "mealType") val mealType: MealType,
    @field:Json(name = "menuType") val menuType: MenuType,
    @field:Json(name = "courseType") val courseType: CourseType,
    @field:Json(name = "special") val special: Special,
)

@JsonClass(generateAdapter = true)
data class CuisineType(
    @field:Json(name = "title") val title: String?,
    @field:Json(name = "description") val description: String?,
    @field:Json(name = "image") val image: String?,
    @field:Json(name = "priority") val priority: Int,
)

@JsonClass(generateAdapter = true)
data class MealType(
    @field:Json(name = "title") val title: String?,
    @field:Json(name = "description") val description: String?,
    @field:Json(name = "image") val image: String?,
    @field:Json(name = "priority") val priority: Int,
)

@JsonClass(generateAdapter = true)
data class MenuType(
    @field:Json(name = "title") val title: String?,
    @field:Json(name = "description") val description: String?,
    @field:Json(name = "image") val image: String?,
    @field:Json(name = "priority") val priority: Int,
)

@JsonClass(generateAdapter = true)
data class CourseType(
    @field:Json(name = "title") val title: String?,
    @field:Json(name = "description") val description: String?,
    @field:Json(name = "image") val image: String?,
    @field:Json(name = "priority") val priority: Int,
)

@JsonClass(generateAdapter = true)
data class Special(
    @field:Json(name = "title") val title: String?,
    @field:Json(name = "description") val description: String?,
    @field:Json(name = "transcript") val transcript: String?,
    @field:Json(name = "policy") val policy: String?,
    @field:Json(name = "image") val image: String?,
    @field:Json(name = "voucher") val voucher: String?,
    @field:Json(name = "beginTime") val beginTime: String?,
    @field:Json(name = "remainingTime") val remainingTime: Int,
    @field:Json(name = "amount") val amount: Int,
    @field:Json(name = "percentage") val percentage: Int,
    @field:Json(name = "limit") val limit: Int,
    @field:Json(name = "value") val value: Int,
    @field:Json(name = "quantity") val quantity: Int,
)

