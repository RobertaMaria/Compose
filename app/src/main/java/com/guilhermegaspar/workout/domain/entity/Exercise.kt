package com.guilhermegaspar.workout.domain.entity

data class Exercise(
    val exercise: List<ExerciseName>
)

data class ExerciseName(
    val name: String
)
