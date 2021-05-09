package com.example.loteriaapp.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class GetApuestaResponse(
    @SerializedName("apuesta_id")
    var id: String,
    @SerializedName("created_date")
    var created_date: Date,
    @SerializedName("sorteo_date")
    var sorteo_date: Date,
    @SerializedName("combinacion")
    var combinacion: String,
    @SerializedName("user_id")
    var user_id: Int
)