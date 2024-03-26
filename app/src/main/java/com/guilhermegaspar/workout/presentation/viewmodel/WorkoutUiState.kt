package com.guilhermegaspar.workout.presentation.viewmodel

import com.guilhermegaspar.workout.domain.entity.ExerciseName
import com.guilhermegaspar.workout.domain.entity.Image
import com.guilhermegaspar.workout.domain.entity.Result

data class WorkoutUiState(
    val list: List<ExerciseName> = arrayListOf(),
    val imageList: List<Result> = arrayListOf()
)
