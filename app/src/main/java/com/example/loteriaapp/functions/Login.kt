package com.example.loteriaapp.functions

import android.content.Context
import android.util.Log
import com.example.loteriaapp.api.ApiClient
import com.example.loteriaapp.model.LoginRequest
import com.example.loteriaapp.model.LoginResponse
import com.example.loteriaapp.model.SessionManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login {
    //private lateinit var sessionManager: SessionManager
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
                        Log.d("error", t.toString())
                    }

                    override fun onResponse(
                            call: Call<List<LoginResponse>>,
                            response: Response<List<LoginResponse>>
                    ) {
                        val loginResponse = response.body()
                        val responseCode = response.code()

                        if (responseCode == 200) {
                            Log.d("cosas", loginResponse.toString())
                            sessionManager.saveUserData(loginResponse!![0].name, loginResponse[0].surname, loginResponse[0].email, loginResponse[0].user_id)
                            toHomeActivity.toHomeActivity(context)
                        } else {
                            // Error logging in
                        }
                    }

                })
    }
}