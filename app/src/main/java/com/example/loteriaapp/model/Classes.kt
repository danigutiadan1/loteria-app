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
    var combinacion: String
)

data class PostApuesta(
    @SerializedName("sorteo_date")
    var sorteo_date: String,
    @SerializedName("combinacion")
    var combinacion: String

)

data class LoginRequest(
        @SerializedName("email")
        var email: String,

        @SerializedName("password")
        var password: String
)

data class ApuestaRequest(
    @SerializedName("user_id")
    var user_id: String,
    @SerializedName("combinacion")
    var combinacion: String,
    @SerializedName("sorteo_date")
    var sorteo_date: Date

)

data class LoginResponse(

        @SerializedName("name")
        var name: String,
        @SerializedName("surname")
        var surname: String,
        @SerializedName("email")
        var email: String,
        @SerializedName("id")
        var user_id: String
)