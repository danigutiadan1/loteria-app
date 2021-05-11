package com.example.loteriaapp.functions

import android.content.Context
import android.content.Intent
import com.example.loteriaapp.views.HomeActivity

class ToHomeActivity {
    fun toHomeActivity(context: Context) {
        val context = context
        val intent = Intent(context, HomeActivity::class.java)
        context.startActivity(intent)
    }
}