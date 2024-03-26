package com.guilhermegaspar.workout.data.service

import com.guilhermegaspar.workout.data.model.ExerciseResponse
import com.guilhermegaspar.workout.data.model.ImageResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface WorkoutService {
    @GET("exercise/")
    suspend fun getExercise(): ExerciseResponse

    @GET("exerciseimage/")
    suspend fun getImage(): ImageResponse
}