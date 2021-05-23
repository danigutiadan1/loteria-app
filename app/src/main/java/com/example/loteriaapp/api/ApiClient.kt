package com.example.loteriaapp.api

import android.content.Context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class ApiClient {
    private lateinit var apiService: ApiService

    fun getApiService(context: Context): ApiService {

        if (!::apiService.isInitialized) {
            var client = OkHttpClient().newBuilder()
                    .connectTimeout(100, TimeUnit.MILLISECONDS)
                    .readTimeout(100, TimeUnit.MILLISECONDS)
                    .writeTimeout(100, TimeUnit.MILLISECONDS)
            val retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                    .client(client.build())
                .build()

            apiService = retrofit.create(ApiService::class.java)
        }

        return apiService
    }
}