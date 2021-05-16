package com.example.loteriaapp.functions

import android.content.Context
import android.content.Intent
import com.example.loteriaapp.views.ApuestasActivity
import com.example.loteriaapp.views.HomeActivity
import com.example.loteriaapp.views.LoginActivity

class ToActivity {
    fun toHomeActivity(context: Context) {
        val context = context
        val intent = Intent(context, HomeActivity::class.java)
        context.startActivity(intent)
    }

    fun toLoginActivity(context: Context) {
        val context = context
        val intent = Intent(context, LoginActivity::class.java)
        context.startActivity(intent)
    }

    fun toApuestasActivity(context: Context) {
        val context = context
        val intent = Intent(context, ApuestasActivity::class.java)
        context.startActivity(intent)
    }
}