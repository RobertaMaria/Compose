package com.guilhermegaspar.workout.data.model

import com.google.gson.annotations.SerializedName

data class ExerciseResponse(
    @SerializedName("results") val exercise: List<ExerciseName>
)
