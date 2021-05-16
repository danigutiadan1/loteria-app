package com.example.loteriaapp.api

object Constants {

    // Endpoints
    const val BASE_URL = "http://192.168.1.176:3000/loteria-api/"

    const val LOGIN_URL = "auth/login"
    const val GETAPUESTAS_URL = "apuestas/{userId}"
    const val GETAPUESTASBYID_URL = "apuestas/{userId}/{apuestaId}"
    const val POSTAPUESTAS_URL = "apuestas/{userId}"

}