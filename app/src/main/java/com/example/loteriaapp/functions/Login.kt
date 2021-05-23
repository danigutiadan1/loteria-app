package com.example.loteriaapp.functions

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.example.loteriaapp.api.ApiClient
import com.example.loteriaapp.model.LoginRequest
import com.example.loteriaapp.model.LoginResponse
import com.example.loteriaapp.model.SessionManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class Login {
    private lateinit var apiClient: ApiClient
    private lateinit var toHomeActivity: ToActivity
    private lateinit var sessionManager: SessionManager


    fun login(context: Context, email: String, password: String) {
        sessionManager= SessionManager(context)
        apiClient = ApiClient()
        toHomeActivity= ToActivity()
        apiClient.getApiService(context).login(LoginRequest(email, password))
                .enqueue(object : Callback<List<LoginResponse>> {
                    override fun onFailure(call: Call<List<LoginResponse>>, t: Throwable) {
                        Toast.makeText(context, "Error de conexión con el servidor...", Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(
                            call: Call<List<LoginResponse>>,
                            response: Response<List<LoginResponse>>
                    ) {
                        val loginResponse = response.body()
                        val responseCode = response.code()

                        if (responseCode == 200) {

                            try {
                                sessionManager.saveUserData(loginResponse!![0].name, loginResponse[0].surname, loginResponse[0].email, loginResponse[0].user_id)
                                toHomeActivity.toHomeActivity(context)
                            } catch (e: Exception) {
                                Toast.makeText(context, "Correo o contraseña incorrectos", Toast.LENGTH_LONG).show()

                            }


                        } else {

                        }
                    }

                })
    }
}