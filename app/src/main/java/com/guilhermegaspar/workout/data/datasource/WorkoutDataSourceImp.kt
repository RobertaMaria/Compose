package com.guilhermegaspar.workout.data.datasource

import com.guilhermegaspar.workout.data.service.WorkoutService
import com.guilhermegaspar.workout.domain.entity.Exercise
import com.guilhermegaspar.workout.domain.entity.ExerciseName
import com.guilhermegaspar.workout.domain.entity.Image
import com.guilhermegaspar.workout.domain.entity.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class WorkoutDataSourceImp(private val service: WorkoutService) : WorkoutDataSource {
    override fun getExercise(): Flow<Exercise> {
        return flow {
            emit(service.getExercise().let {
                Exercise(
                    exercise = it.exercise.map {
                        ExerciseName(it.name)
                    }
                )
            })
        }
    }

    override fun getImage(): Flow<Image> {
        return flow {
            emit(service.getImage().let {
                Image(
                    result = it.image.map {
                        Result(it.image)
                    }
                )
            })
        }
    }
}