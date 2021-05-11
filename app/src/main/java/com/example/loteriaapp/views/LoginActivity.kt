package com.example.loteriaapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.loteriaapp.R
import com.example.loteriaapp.functions.GetApuestas
import com.example.loteriaapp.functions.Login

private lateinit var login: Login
private lateinit var etEmail: EditText
private lateinit var etPassword: EditText
private lateinit var btnLogin: Button
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        etEmail= findViewById(R.id.etEmail) as EditText
        etPassword= findViewById(R.id.etPassword) as EditText
        btnLogin= findViewById(R.id.btnLogin) as Button
        login = Login()

        btnLogin.setOnClickListener {
            login.login(this, etEmail.text.toString(), etPassword.text.toString())
        }
    }
}