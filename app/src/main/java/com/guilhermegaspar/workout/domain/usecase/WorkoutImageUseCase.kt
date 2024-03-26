package com.guilhermegaspar.workout.domain.usecase

import com.guilhermegaspar.workout.domain.entity.Image
import com.guilhermegaspar.workout.domain.repository.WorkoutRepository
import kotlinx.coroutines.flow.Flow

class WorkoutImageUseCase(private val repository: WorkoutRepository) {
    operator fun invoke(): Flow<Image> {
        return repository.getImage()
    }
}