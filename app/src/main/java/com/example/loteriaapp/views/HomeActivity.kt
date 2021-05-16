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
        Log.d("userSession", sessionManager.getUserId()!!)

        val localDate: LocalDate = LocalDate.now()
        Log.d("noc", localDate.toString())



        val nuevaApuesta= PostApuesta( localDate.toString(), "1, 2, 3, 4" )
            viewModel.saveApuesta("1", nuevaApuesta)

        btnApuesta.setOnClickListener{
           toActivity.toApuestasActivity(this)
        }




    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
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