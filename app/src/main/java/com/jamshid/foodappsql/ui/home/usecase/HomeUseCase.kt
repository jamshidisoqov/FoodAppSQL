package com.jamshid.foodappsql.ui.home.usecase

import com.jamshid.foodappsql.domain.models.Food
import com.jamshid.foodappsql.domain.repository.Repository
import com.jamshid.foodappsql.domain.response.FoodResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HomeUseCase(private var repository: Repository) {

    operator fun invoke(): Flow<FoodResponse<List<Food>>> = flow {
        try {

            emit(FoodResponse.Loading())

            val allContact = repository.getAllFood()

            emit(FoodResponse.Success(allContact))

        } catch (e: Exception) {

            e.printStackTrace()

            emit(FoodResponse.Error(e.localizedMessage ?: "Error"))
        }
    }

}