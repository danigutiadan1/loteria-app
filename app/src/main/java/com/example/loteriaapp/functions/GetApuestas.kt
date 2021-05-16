package com.example.loteriaapp.functions

import android.content.Context
import android.util.Log
import com.example.loteriaapp.api.ApiClient
import com.example.loteriaapp.model.GetApuestaResponse
import com.example.loteriaapp.model.SessionManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private var apuestasResponse: List<GetApuestaResponse>? = null
class GetApuestas {


    //private lateinit var sessionManager: SessionManager
    private lateinit var apiClient: ApiClient
    private lateinit var user_id: String
    private lateinit var sessionManager: SessionManager


    /**fun getApuestas(context: Context) {
        apiClient = ApiClient()
        sessionManager= SessionManager(context)
        user_id= sessionManager.getUserId()!!
        apiClient.getApiService(context).getApuestas(user_id)
            .enqueue(object : Callback<List<GetApuestaResponse>> {
                override fun onFailure(call: Call<List<GetApuestaResponse>>, t: Throwable) {
                    Log.d("error", t.toString())
                }

                override fun onResponse(
                    call: Call<List<GetApuestaResponse>>,
                    response: Response<List<GetApuestaResponse>>
                ) {
                     apuestasResponse = response.body()
                    val responseCode = response.code()

                    if (responseCode == 200) {

                        Log.d("combinacion", apuestasResponse.toString())
                        sessionManager.saveUserApuestas(apuestasResponse!!)


                    } else {
                        // Error logging in
                    }

                }

            })
    }
*/
     fun getList(): List<GetApuestaResponse>? {
         return apuestasResponse
     }

}