package com.example.loteriaapp.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by pacopulido on 23/02/2021.
 */

object WebAccess {

    val loteriaService : ApiService by lazy {

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .baseUrl(Constants.BASE_URL)
            .build()

        return@lazy retrofit.create(ApiService::class.java)
    }
}