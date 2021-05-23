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