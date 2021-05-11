package com.example.loteriaapp.model

import android.content.Context
import android.content.SharedPreferences

class SessionManager(context: Context) {
    private val name= "LoteriaApp"
    private val prefs: SharedPreferences= context.getSharedPreferences(name, Context.MODE_PRIVATE)

    companion object{
        const val NAME= "name"
        const val SURNAME= "surname"
        const val EMAIL= "email"
        const val USER_ID= "user_id"
    }

    fun saveUserData(name: String, surname: String, email: String, user_id: String){
        val editor= prefs.edit()
        editor.putString(NAME, name)
        editor.putString(SURNAME, surname)
        editor.putString(EMAIL, email)
        editor.putString(USER_ID, user_id)
        editor.apply()
    }

    fun clearShared(){
        val editor= prefs.edit()
        editor.clear()
        editor.apply()
    }

    fun getUserId(): Int?{
        return prefs.getInt(USER_ID, 0)
    }
}