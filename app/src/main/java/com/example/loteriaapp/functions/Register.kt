package com.example.loteriaapp.functions


import android.content.Context
import android.util.Log
import android.widget.Toast
import com.example.loteriaapp.api.ApiClient
import com.example.loteriaapp.model.LoginResponse
import com.example.loteriaapp.model.RegisterRequest
import com.example.loteriaapp.model.SessionManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Register {
    private lateinit var apiClient: ApiClient
    private lateinit var toLoginActivity: ToActivity
    private lateinit var sessionManager: SessionManager


    fun register(context: Context, email: String, name:String, surname:String, dni:String, password: String) {
        sessionManager= SessionManager(context)
        apiClient = ApiClient()
        toLoginActivity= ToActivity()
        apiClient.getApiService(context).register(RegisterRequest(email, name, surname, dni, password))
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
                        Toast.makeText(context, "Se ha registrado correctamente, ahora inicie sesión", Toast.LENGTH_LONG).show()
                        toLoginActivity.toLoginActivity(context)
                    } else {
                        Toast.makeText(context, "Algo ha ido mal... Inténtelo de nuevo", Toast.LENGTH_LONG).show()
                    }
                }

            })
    }
}