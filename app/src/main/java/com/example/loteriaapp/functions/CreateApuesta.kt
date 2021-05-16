package com.example.loteriaapp.functions

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.example.loteriaapp.api.ApiClient
import com.example.loteriaapp.model.ApuestaRequest
import com.example.loteriaapp.model.GetApuestaResponse
import com.example.loteriaapp.model.SessionManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


class CreateApuesta {
    private lateinit var apiClient: ApiClient
    private lateinit var user_id: String
    private lateinit var sessionManager: SessionManager


    /*fun createApuesta(context: Context, combinacion: String, sorteo_date: Date) {
        apiClient = ApiClient()
        sessionManager= SessionManager(context)
        user_id= sessionManager.getUserId()!!
        apiClient.getApiService(context).createApuesta(ApuestaRequest(user_id, combinacion, sorteo_date))
            .enqueue(object : Callback<Void> {
                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Log.d("error", t.toString())
                }

                override fun onResponse(
                    call: Call<Void>,
                    response: Response<Void>
                ) {

                    val responseCode = response.code()

                    if (responseCode == 200) {

                        Toast.makeText(context, "Apuesta completada", Toast.LENGTH_LONG).show()

                    } else {
                        Toast.makeText(context, "Ha ocurrido un error", Toast.LENGTH_LONG).show()
                    }

                }

            })
    }
*/
}