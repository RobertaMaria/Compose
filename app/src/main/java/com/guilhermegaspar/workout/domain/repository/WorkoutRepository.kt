package com.guilhermegaspar.workout.domain.repository

import com.guilhermegaspar.workout.domain.entity.Exercise
import com.guilhermegaspar.workout.domain.entity.Image
import kotlinx.coroutines.flow.Flow

interface WorkoutRepository {
    fun getExercise(): Flow<Exercise>
    fun getImage(): Flow<Image>
}