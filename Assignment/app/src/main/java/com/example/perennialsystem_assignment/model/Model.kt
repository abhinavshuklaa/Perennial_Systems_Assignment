package com.example.perennialsystem_assignment.model


import com.google.gson.annotations.SerializedName

data class Model(
    @SerializedName("data")
    val `data`: List<Data>?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("status")
    val status: String?
)