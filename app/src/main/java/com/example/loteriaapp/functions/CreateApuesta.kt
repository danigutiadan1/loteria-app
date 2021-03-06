package com.example.loteriaapp.functions

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.example.loteriaapp.api.ApiClient
import com.example.loteriaapp.model.GetApuestaResponse
import com.example.loteriaapp.model.PostApuesta
import com.example.loteriaapp.model.SessionManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CreateApuesta {
    private lateinit var apiClient: ApiClient
    private lateinit var user_id: String
    private lateinit var sessionManager: SessionManager


    fun createApuesta(context: Context, combinacion: String, sorteo_date: String) {
        apiClient = ApiClient()
        sessionManager= SessionManager(context)
        user_id= sessionManager.getUserId()!!
        apiClient.getApiService(context).saveApuesta(user_id, PostApuesta(sorteo_date, combinacion))
            .enqueue(object : Callback<Void> {
                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(context, "Error de conexión con el servidor...", Toast.LENGTH_LONG).show()
                }

                override fun onResponse(
                    call: Call<Void>,
                    response: Response<Void>
                ) {

                    val responseCode = response.code()

                    if (responseCode == 201) {

                        Toast.makeText(context, "Apuesta completada", Toast.LENGTH_LONG).show()

                    } else {
                        Toast.makeText(context, "Ha ocurrido un error", Toast.LENGTH_LONG).show()
                    }

                }

            })
    }
}