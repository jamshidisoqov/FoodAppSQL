package com.jamshid.foodappsql.data.model.local

import com.jamshid.foodappsql.domain.models.Food


interface DbQuery {

    suspend fun insertFood(food: Food)

    suspend fun getAllFood(): List<Food>

    suspend fun searchFood(): List<Food>

    suspend fun deleteFood(pos: Int)
    
    suspend fun deleteAllFood()

}