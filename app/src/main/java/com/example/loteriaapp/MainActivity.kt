package com.example.loteriaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loteriaapp.functions.GetApuestas

private lateinit var getApuestas: GetApuestas
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getApuestas= GetApuestas()

        getApuestas.getApuestas(this)
    }
}