package com.example.loteriaapp.viewmodels

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.loteriaapp.api.MainRepository
import com.example.loteriaapp.model.GetApuestaResponse
import com.example.loteriaapp.model.PostApuesta
import com.example.loteriaapp.model.SessionManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ApuestasViewModel : ViewModel() {


    private var repository: MainRepository = MainRepository()

    fun getDataApuestas( user_id:String): MutableLiveData<List<GetApuestaResponse>> {
        val apuestas = MutableLiveData<List<GetApuestaResponse>>()
        GlobalScope.launch(Dispatchers.Main) {
            apuestas.value = repository.getDataApuestas(user_id)
        }
        return apuestas
    }


}
