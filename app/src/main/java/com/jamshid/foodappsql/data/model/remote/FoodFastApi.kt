package com.jamshid.foodappsql.data.model.remote

import com.jamshid.foodappsql.domain.models.Food
import com.jamshid.foodappsql.domain.repository.Repository
import retrofit2.http.GET

interface FoodFastApi {
    @GET("/v1/food/all")
    suspend fun getAllFood(): List<Food>

}