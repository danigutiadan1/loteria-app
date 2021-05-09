package com.example.loteriaapp.api

import com.example.loteriaapp.model.GetApuestaResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET(Constants.GETAPUESTAS_URL)
    fun getApuestas(): Call<List<GetApuestaResponse>>
}