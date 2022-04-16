package com.jamshid.foodappsql.domain.response


sealed class FoodResponse<T>(val data: T? = null, val message: String? = null) {

    class Success<T>(data: T?) : FoodResponse<T>(data = data)
    class Error<T>(message: String?) : FoodResponse<T>(message = message)
    class Loading<T>() : FoodResponse<T>()

}
