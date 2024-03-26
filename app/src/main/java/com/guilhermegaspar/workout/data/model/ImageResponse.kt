package com.guilhermegaspar.workout.data.model

import com.google.gson.annotations.SerializedName

data class ImageResponse(
    @SerializedName("results") val image: List<ImageName>
)
data class ImageName(
    @SerializedName("image")val image: String
)
