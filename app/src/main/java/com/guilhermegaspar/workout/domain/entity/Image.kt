package com.guilhermegaspar.workout.domain.entity

data class Image(
    val result: List<Result>
)

data class Result(
    val image: String
)
