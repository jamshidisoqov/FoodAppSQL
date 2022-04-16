package com.jamshid.foodappsql.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jamshid.foodappsql.domain.models.Food
import com.jamshid.foodappsql.domain.response.FoodResponse
import com.jamshid.foodappsql.domain.ui_state.FoodUiState
import com.jamshid.foodappsql.ui.home.usecase.HomeUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(val useCase: HomeUseCase) : ViewModel() {

    private var _state:MutableStateFlow<FoodUiState> = MutableStateFlow(FoodUiState())
    val state: StateFlow<FoodUiState> get() = _state


    init {
        viewModelScope.launch {
            useCase.invoke().collect{
                when(it) {
                    is FoodResponse.Loading -> {
                        _state.value = FoodUiState(isLoading = true)
                    }
                    is FoodResponse.Error -> {
                        _state.value = FoodUiState(message = it.message)
                    }
                    is FoodResponse.Success -> {
                        _state.value = FoodUiState(data = it.data)
                    }
                }
            }
        }
    }

}