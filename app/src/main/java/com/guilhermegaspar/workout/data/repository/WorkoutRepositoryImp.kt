package com.guilhermegaspar.workout.data.repository

import com.guilhermegaspar.workout.data.datasource.WorkoutDataSource
import com.guilhermegaspar.workout.domain.entity.Exercise
import com.guilhermegaspar.workout.domain.entity.Image
import com.guilhermegaspar.workout.domain.repository.WorkoutRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WorkoutRepositoryImp(private val dataSource: WorkoutDataSource): WorkoutRepository {
    override fun getExercise(): Flow<Exercise> {
        return dataSource.getExercise()
    }

    override fun getImage(): Flow<Image> {
        return dataSource.getImage()
    }

}