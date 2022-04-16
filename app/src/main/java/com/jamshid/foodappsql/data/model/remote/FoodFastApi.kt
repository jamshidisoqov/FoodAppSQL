package com.jamshid.foodappsql.data.model.remote

import com.jamshid.foodappsql.domain.models.Food
import com.jamshid.foodappsql.domain.repository.Repository
import retrofit2.http.GET

interface FoodFastApi {
    @GET("")
    suspend fun getAllFood(): List<Food>
}