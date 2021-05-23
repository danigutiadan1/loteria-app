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
}
