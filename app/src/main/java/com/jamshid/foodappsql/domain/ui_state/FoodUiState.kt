package com.jamshid.foodappsql.domain.ui_state

import com.jamshid.foodappsql.domain.models.Food

data class FoodUiState(
    var isLoading: Boolean = false,
    var data: List<Food>? = emptyList(),
    var message: String? = null
)
