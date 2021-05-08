package com.example.resturantsapplication.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.VisibleForTesting
import com.example.resturantsapplication.R
import com.example.resturantsapplication.databinding.ActivityMainBinding
import com.example.resturantsapplication.ui.adapter.RestaurantAdapterH
import com.example.resturantsapplication.ui.adapter.RestaurantAdapterV
import com.skydoves.bindables.BindingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RestaurantActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {

    @VisibleForTesting
    val viewModel: RestaurantViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding {
            lifecycleOwner = this@RestaurantActivity
            adapterHorizontal = RestaurantAdapterH()
            adapterVertical = RestaurantAdapterV()
            vm = viewModel
        }
        
    }
}