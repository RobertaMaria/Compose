package com.guilhermegaspar.workout.domain.usecase

import com.guilhermegaspar.workout.domain.entity.Exercise
import com.guilhermegaspar.workout.domain.repository.WorkoutRepository
import kotlinx.coroutines.flow.Flow


class WorkoutExerciseUseCase(private val repository: WorkoutRepository) {
    operator fun invoke(): Flow<Exercise> {
        return repository.getExercise()
    }
}