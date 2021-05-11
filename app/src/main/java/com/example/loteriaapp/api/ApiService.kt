package com.example.loteriaapp.api

import com.example.loteriaapp.model.GetApuestaResponse
import com.example.loteriaapp.model.LoginRequest
import com.example.loteriaapp.model.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    @GET(Constants.GETAPUESTAS_URL)
    fun getApuestas(@Path("user_id")user_id: Int): Call<List<GetApuestaResponse>>

    @POST(Constants.LOGIN_URL)
    fun login(@Body request: LoginRequest): Call<List<LoginResponse>>
}