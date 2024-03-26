package com.guilhermegaspar.workout.data.datasource

import com.guilhermegaspar.workout.data.model.ExerciseResponse
import com.guilhermegaspar.workout.domain.entity.Exercise
import com.guilhermegaspar.workout.domain.entity.Image
import kotlinx.coroutines.flow.Flow

interface WorkoutDataSource {
    fun getExercise(): Flow<Exercise>
    fun getImage(): Flow<Image>
}