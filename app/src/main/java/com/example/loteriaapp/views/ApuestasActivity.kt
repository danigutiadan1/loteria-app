package com.example.loteriaapp.views

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.loteriaapp.R
import com.example.loteriaapp.adapters.AdapterApuesta
import com.example.loteriaapp.functions.ToActivity
import com.example.loteriaapp.model.GetApuestaResponse
import com.example.loteriaapp.model.SessionManager
import com.example.loteriaapp.viewmodels.ApuestasViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

private lateinit var rvApuestas: RecyclerView
private lateinit var adapter: AdapterApuesta

class ApuestasActivity : AppCompatActivity() {

    private lateinit var apuestas: List<GetApuestaResponse>
    private lateinit var viewModel: ApuestasViewModel
    private lateinit var sessionManager: SessionManager
    private lateinit var toActivity: ToActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apuestas)
        setSupportActionBar(findViewById(R.id.toolbar))
        sessionManager= SessionManager(this)
        rvApuestas= findViewById<RecyclerView>(R.id.rvApuestas)
        toActivity= ToActivity()
        viewModel= ApuestasViewModel()
        GlobalScope.async {
        }

        initRV()

        loadApuestas()

        findViewById<FloatingActionButton>(R.id.fabAddApuesta).setOnClickListener { view ->
            toActivity.toCreateApuestaActivity(this)
        }
    }

    private fun initRV() {
        adapter = AdapterApuesta(this, R.layout.rowapuesta)
        rvApuestas.layoutManager = LinearLayoutManager(this)
        rvApuestas.adapter = adapter
    }
    private fun loadApuestas() {
        viewModel = ViewModelProvider(this).get(ApuestasViewModel::class.java)
        viewModel.getDataApuestas(sessionManager.getUserId()!!).observe(this, Observer { it ->
            it?.let{
                apuestas=it
                adapter.setApuestas(apuestas)
            }
        })

    }

    override fun onBackPressed(){
        finish()
        toActivity.toHomeActivity(this)
    }







}