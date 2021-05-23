package com.example.loteriaapp.api

import com.example.loteriaapp.model.*
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    @GET(Constants.GETAPUESTAS_URL)
    fun getApuestas(@Path("userId")user_id: String): Deferred<Response<List<GetApuestaResponse>>>

    @GET(Constants.GETAPUESTASBYID_URL)
    fun getApuestasById(
        @Path("userId")user_id: String,
        @Path("apuestaId") apuestaId: String): Call<List<GetApuestaResponse>>


    @POST(Constants.LOGIN_URL)
    fun login(@Body request: LoginRequest): Call<List<LoginResponse>>

    @POST(Constants.POSTUSER_URL)
    fun register(@Body request: RegisterRequest): Call<Void>


    @POST(Constants.POSTAPUESTAS_URL)
    fun saveApuesta(@Path ("userId")userId: String, @Body apuesta: PostApuesta): Call<Void>
}