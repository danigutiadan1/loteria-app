package com.example.loteriaapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.loteriaapp.R
import com.example.loteriaapp.functions.Login
import com.example.loteriaapp.functions.ToActivity
import com.example.loteriaapp.model.SessionManager

private lateinit var login: Login
private lateinit var etEmail: EditText
private lateinit var etPassword: EditText
private lateinit var btnLogin: Button
private lateinit var btnRegister: Button
private lateinit var sessionManager: SessionManager
private lateinit var toActivity: ToActivity
class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        toActivity= ToActivity()
        sessionManager= SessionManager(this)
        etEmail= findViewById(R.id.etEmail) as EditText
        etPassword= findViewById(R.id.etPassword) as EditText
        btnLogin= findViewById(R.id.btnLogin) as Button
        btnRegister= findViewById(R.id.btnRegister) as Button


        login = Login()

        if (sessionManager.isLogged()) {
            toActivity.toHomeActivity(this)
        } else {
            btnLogin.setOnClickListener {
                login.login(this, etEmail.text.toString(), etPassword.text.toString())
            }
        }

        btnRegister.setOnClickListener{
            toActivity.toRegisterActivity(this)
        }
    }
}