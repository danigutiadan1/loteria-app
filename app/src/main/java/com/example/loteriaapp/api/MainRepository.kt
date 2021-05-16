package com.example.loteriaapp.api

import com.example.loteriaapp.model.GetApuestaResponse
import com.example.loteriaapp.model.PostApuesta
import retrofit2.await

class MainRepository() {
    val service = WebAccess.loteriaService

    suspend fun getDataApuestas(user_id:String): List<GetApuestaResponse> {
        val webResponse = service.getApuestas(user_id).await()
        if (webResponse.isSuccessful) {
            return webResponse.body()!!
        }
        return emptyList()
    }


    suspend fun saveApuesta(user_id:String, apuesta: PostApuesta): PostApuesta? {
        var apuestaresponse: PostApuesta? = null
        val webResponse = service.saveApuesta(user_id, apuesta).await()
        if (webResponse.isSuccessful) {
            apuestaresponse = webResponse.body()!!
        }
        return apuestaresponse
    }

}
