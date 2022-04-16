package com.jamshid.foodappsql.domain.repository

import com.jamshid.foodappsql.data.model.local.DbQueryImpl
import com.jamshid.foodappsql.data.model.remote.FoodFastApi
import com.jamshid.foodappsql.domain.models.Food

class Repository(private val api: FoodFastApi,private val dbQueryImpl:DbQueryImpl) {

    suspend fun getAllFood():List<Food>{

        return api.getAllFood()

    }

}