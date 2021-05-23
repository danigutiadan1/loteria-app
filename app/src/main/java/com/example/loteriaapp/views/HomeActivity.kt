package com.example.loteriaapp.views

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.loteriaapp.R
import com.example.loteriaapp.functions.Logout
import com.example.loteriaapp.functions.ToActivity
import com.example.loteriaapp.model.GetApuestaResponse
import com.example.loteriaapp.model.PostApuesta
import com.example.loteriaapp.model.SessionManager
import com.example.loteriaapp.viewmodels.ApuestasViewModel
import java.time.LocalDate

private lateinit var tvWelcome: TextView
private lateinit var sessionManager: SessionManager
private lateinit var btnApuesta: Button
private lateinit var toActivity: ToActivity
private lateinit var logout: Logout
private lateinit var viewModel: ApuestasViewModel

class HomeActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(findViewById(R.id.toolbar))
        sessionManager= SessionManager(this)
        toActivity= ToActivity()
        logout= Logout()
        viewModel= ApuestasViewModel()
        tvWelcome= findViewById(R.id.tvWelcome) as TextView
        btnApuesta= findViewById(R.id.btnApuestas) as Button
        tvWelcome.text= "Bienvenid@, ${sessionManager.getUserName()}"


        val localDate: LocalDate = LocalDate.now()



        btnApuesta.setOnClickListener{
           toActivity.toApuestasActivity(this)
        }




    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_logout -> {
                logout.logout(this)
                toActivity.toLoginActivity(this)
                Toast.makeText(this, "Ha cerrado sesión...", Toast.LENGTH_LONG).show()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}