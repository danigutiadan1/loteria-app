package com.example.loteriaapp.functions

import android.content.Context
import com.example.loteriaapp.model.SessionManager


private lateinit var sessionManager: SessionManager
    class Logout {
    fun logout(context: Context) {
        sessionManager= SessionManager(context)
        sessionManager.clearShared()
    }
}