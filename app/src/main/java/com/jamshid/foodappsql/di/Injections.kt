package com.jamshid.foodappsql.di

import com.google.gson.GsonBuilder
import com.jamshid.foodappsql.common.RemoteConstants
import com.jamshid.foodappsql.data.model.local.DbHelper
import com.jamshid.foodappsql.data.model.local.DbQueryImpl
import com.jamshid.foodappsql.data.model.remote.FoodFastApi
import com.jamshid.foodappsql.domain.models.Food
import com.jamshid.foodappsql.domain.repository.Repository
import com.jamshid.foodappsql.ui.home.HomeViewModel
import com.jamshid.foodappsql.ui.home.usecase.HomeUseCase
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.parameter.ParametersHolder
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


private const val timeOut = 50L

val viewModelModule = module {

    viewModel { HomeViewModel(get())}

}
val useCaseModule = module {

    single { HomeUseCase(get())}

}


val dataModule = module {

    single { DbHelper(androidContext()) }
    single { DbQueryImpl(get()) }
    single { Repository(get(), dbQueryImpl = get()) }

}

val networkModule = module {
    single {
        GsonBuilder().setLenient().create()
    }

    single {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(timeout = timeOut, TimeUnit.SECONDS)
            .readTimeout(timeout = timeOut, TimeUnit.SECONDS)
            .writeTimeout(timeout = timeOut, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .build()
    }

    single(named("api")) {
        Retrofit
            .Builder()
            .baseUrl(RemoteConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(get()))
            .client(get())
            .build()
    }

    single {
        get<Retrofit>(named("api")).create(FoodFastApi::class.java)
    }

}

