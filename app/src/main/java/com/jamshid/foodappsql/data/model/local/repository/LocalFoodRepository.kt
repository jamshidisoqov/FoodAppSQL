package com.jamshid.foodappsql.data.model.local.repository

import com.jamshid.foodappsql.domain.models.Food
import com.jamshid.foodappsql.domain.repository.Repository

interface LocalFoodRepository{
    suspend fun getAllFood(): List<Food> {
        return emptyList()
    }
}