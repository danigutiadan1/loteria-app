package com.example.loteriaapp.views

import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.loteriaapp.R
import com.example.loteriaapp.functions.CreateApuesta
import com.example.loteriaapp.functions.ToActivity
import java.text.SimpleDateFormat


private lateinit var etDateCreateApuesta: EditText
private lateinit var btnCreateApuesta: Button
private lateinit var etn1: EditText
private lateinit var etn2: EditText
private lateinit var etn3: EditText
private lateinit var etn4: EditText
private lateinit var etn5: EditText
private lateinit var createApuesta: CreateApuesta
private lateinit var calendarView: CalendarView
private lateinit var tvDateCreateApuesta: TextView
private lateinit var toActivity: ToActivity
private lateinit var mes: String
private lateinit var dia: String
class CreateApuestaActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_apuesta)

        btnCreateApuesta= findViewById(R.id.btnCreateApuesta) as Button
        createApuesta= CreateApuesta()
        etn1= findViewById(R.id.etn1) as EditText
        etn2= findViewById(R.id.etn2) as EditText
        etn3= findViewById(R.id.etn3) as EditText
        etn4= findViewById(R.id.etn4) as EditText
        etn5= findViewById(R.id.etn5) as EditText
        toActivity= ToActivity()
        tvDateCreateApuesta= findViewById(R.id.tvDateCreateApuesta)
        calendarView= findViewById(R.id.calendarCreateApuesta)

        calendarView.setOnDateChangeListener { calendarView, i, i1, i2 ->
            if(i1<10){
                mes= "0${i1+1}"
            } else{
                mes= "${i1+1}"
            }

            if(i2<10){
                dia= "0${i2}"
            } else{
                dia= "${i2}"
            }

            val fecha = "$i-${mes}-${dia}"
            tvDateCreateApuesta.text= fecha

        }

        btnCreateApuesta.setOnClickListener{


            if(etn1.text.toString() == "" || etn2.text.toString() == "" || etn3.text.toString() == "" || etn4.text.toString() == "" || etn5.text.toString() == ""){
                Toast.makeText(this, "Rellene todos los números antes de continuar...", Toast.LENGTH_LONG).show()
            } else if(tvDateCreateApuesta.text.toString()==""){
                Toast.makeText(this, "Elija una fecha de sorteo...", Toast.LENGTH_LONG).show()

        }else {
                val combinacion= "${etn1.text}, ${etn2.text}, ${etn3.text}, ${etn4.text}, ${etn5.text}"
                createApuesta.createApuesta(this, combinacion, tvDateCreateApuesta.text.toString())
                toActivity.toApuestasActivity(this)
            }

        }
    }


}