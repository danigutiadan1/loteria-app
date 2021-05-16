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

/**
 * Created by pacopulido on 23/02/2021.
 */
class ApuestasViewModel : ViewModel() {


    private var repository: MainRepository = MainRepository()

    fun getDataApuestas( user_id:String): MutableLiveData<List<GetApuestaResponse>> {
        val apuestas = MutableLiveData<List<GetApuestaResponse>>()
        GlobalScope.launch(Dispatchers.Main) {
            apuestas.value = repository.getDataApuestas(user_id)
        }
        return apuestas
    }

    fun saveApuesta(user_id: String, apuesta: PostApuesta): MutableLiveData<PostApuesta> {
        val apuestaresponse= MutableLiveData<PostApuesta>()
        GlobalScope.launch(Dispatchers.Main) {
            apuestaresponse.value = repository.saveApuesta(user_id, apuesta)
        }
        return apuestaresponse
    }

}
