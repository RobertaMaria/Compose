package com.guilhermegaspar.workout.data.retrofit

import android.content.Context
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig() {
    fun getRetrofitInstance() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://wger.de/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}