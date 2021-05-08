package com.example.resturantsapplication.data.repositories

import androidx.annotation.WorkerThread
import com.example.resturantsapplication.di.network.RestaurantClient
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onException
import com.skydoves.sandwich.suspendOnSuccess
import com.skydoves.whatif.whatIfNotNull
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class RestaurantRepo @Inject constructor(
    private val restaurantClient: RestaurantClient,
) : Repository {

    @WorkerThread
    fun listFoods(
        onStart: () -> Unit,
        onComplete: () -> Unit,
        onError: (String?) -> Unit
    ) = flow {
            val response = restaurantClient.fetchFoods()
            response.suspendOnSuccess {
                data.whatIfNotNull { response ->
                    emit(response)
                }
            }.onError {
                //handle error
                }
                .onException { onError(message) }

    }.onStart { onStart() }.onCompletion { onComplete() }.flowOn(Dispatchers.IO)
}