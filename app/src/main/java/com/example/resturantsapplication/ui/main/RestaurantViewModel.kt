package com.example.resturantsapplication.ui.main

import androidx.databinding.Bindable
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.resturantsapplication.data.model.foodmodel.Food
import com.example.resturantsapplication.data.repositories.RestaurantRepo
import com.skydoves.bindables.BindingViewModel
import com.skydoves.bindables.asBindingProperty
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor(
    private val restaurantRepo: RestaurantRepo,
    private val savedStateHandle: SavedStateHandle
) : BindingViewModel() {

    private val foodlistFetchingIndex: MutableStateFlow<Int> = MutableStateFlow(0)
    private val foodListFlow = foodlistFetchingIndex.flatMapLatest { page ->
        restaurantRepo.listFoods(
            onStart = { /*example action --> isLoading = true*/ },
            onComplete = { /*example action --> isLoading = false*/ },
            onError = { /*example action --> toastMessage = it*/ }
        )
    }

    @get:Bindable
    val listFood: List<Food> by foodListFlow.asBindingProperty(viewModelScope, emptyList())

}
