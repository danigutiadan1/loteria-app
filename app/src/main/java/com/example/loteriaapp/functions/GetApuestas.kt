package com.example.loteriaapp.functions

import android.content.Context
import android.util.Log
import com.example.loteriaapp.api.ApiClient
import com.example.loteriaapp.model.GetApuestaResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetApuestas {
    //private lateinit var sessionManager: SessionManager
    private lateinit var apiClient: ApiClient
    private var user_id: Int=0


    fun getApuestas(context: Context) {
        apiClient = ApiClient()
        apiClient.getApiService(context).getApuestas(user_id)
            .enqueue(object : Callback<List<GetApuestaResponse>> {
                override fun onFailure(call: Call<List<GetApuestaResponse>>, t: Throwable) {
                    Log.d("error", t.toString())
                }

                override fun onResponse(
                    call: Call<List<GetApuestaResponse>>,
                    response: Response<List<GetApuestaResponse>>
                ) {
                    val apuestasResponse = response.body()
                    val responseCode = response.code()

                    if (responseCode == 200) {
                        Log.d("combinacion", apuestasResponse.toString())
                    } else {
                        // Error logging in
                    }
                }

            })
    }
}