package com.example.loteriaapp.model

import com.google.gson.annotations.SerializedName
import com.soywiz.klock.DateTime
import java.util.*

data class GetApuestaResponse(
    @SerializedName("apuesta_id")
    var id: String,
    @SerializedName("created_date")
    var created_date: Date,
    @SerializedName("sorteo_date")
    var sorteo_date: String,
    @SerializedName("combinacion")
    var combinacion: String
)

data class PostApuesta(
    @SerializedName("sorteo_date")
    var sorteo_date: String,
    @SerializedName("combinacion")
    var combinacion: String

)

data class RegisterRequest(
    @SerializedName("email")
    var email: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("surname")
    var surname: String,
    @SerializedName("dni")
    var dni: String,
    @SerializedName("password")
    var password: String

)

data class LoginRequest(
        @SerializedName("email")
        var email: String,

        @SerializedName("password")
        var password: String
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