package com.example.loteriaapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.loteriaapp.R
import com.example.loteriaapp.functions.Register

private lateinit var etName: EditText
private lateinit var etSurname: EditText
private lateinit var etDni: EditText
private lateinit var etPassword: EditText
private lateinit var etEmail: EditText
private lateinit var btnRegister: Button
private lateinit var register: Register
class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        etName= findViewById(R.id.etRegisterName) as EditText
        etSurname= findViewById(R.id.etRegisterSurname) as EditText
        etDni= findViewById(R.id.etRegisterDni) as EditText
        etPassword= findViewById(R.id.etRegisterPassword) as EditText
        etEmail= findViewById(R.id.etRegisterEmail) as EditText
        btnRegister= findViewById(R.id.btnRegisterRegister) as Button
        register= Register()
        btnRegister.setOnClickListener{
            register.register(this, etEmail.text.toString(), etName.text.toString(), etSurname.text.toString(), etDni.text.toString(), etPassword.text.toString())
        }
    }

}