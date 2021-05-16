package com.example.loteriaapp.model

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken







class SessionManager(context: Context) {
    private val name= "LoteriaApp"
    private val prefs: SharedPreferences= context.getSharedPreferences(name, Context.MODE_PRIVATE)

    companion object{
        const val NAME= "name"
        const val SURNAME= "surname"
        const val EMAIL= "email"
        const val USER_ID= "user_id"
        const val APUESTA= "apuesta "
    }

    fun saveUserData(name: String, surname: String, email: String, user_id: String){
        val editor= prefs.edit()
        editor.putString(NAME, name)
        editor.putString(SURNAME, surname)
        editor.putString(EMAIL, email)
        editor.putString(USER_ID, user_id)
        editor.apply()
    }

    fun isLogged(): Boolean{
        return prefs.contains(USER_ID)
    }

    fun saveUserApuestas(apuestas: List<GetApuestaResponse>){
        val editor= prefs.edit()

        val gson = Gson()
        val json = gson.toJson(apuestas)
        editor.putString("apuestas", json)
        //for ((index, apuesta) in apuestas.withIndex()) {
          //  editor.putString(APUESTA+index, apuesta.combinacion)
        //}
        editor.apply()
    }

    fun saveUserApuesta(apuesta: GetApuestaResponse){
        val editor= prefs.edit()

        val gson = Gson()
        val json = gson.toJson(apuesta)
        editor.putString("apuesta", json)
        editor.apply()

    }

    fun getApuestaFromShared(): GetApuestaResponse{
        val gson = Gson()
        val json = prefs.getString("apuesta", "")
        val apuesta= gson.fromJson(json, GetApuestaResponse::class.java)
        return apuesta
    }
    fun getApuestasFromShared(): List<GetApuestaResponse> {
        val gson = Gson()
        val json = prefs.getString("apuestas", "")
        val objectList = gson.fromJson(json, Array<GetApuestaResponse>::class.java).asList()
        return objectList
    }

    fun clearShared(){
        val editor= prefs.edit()
        editor.clear()
        editor.commit()
    }

    fun getUserId(): String?{
        return prefs.getString(USER_ID, "")
    }

    fun getUserName(): String? {
        return prefs.getString(NAME, "")
    }

    fun getUserSurname(): String?{
        return prefs.getString(SURNAME, "")
    }

    fun getUserEmail(): String?{
        return prefs.getString(EMAIL, "S")
    }
}