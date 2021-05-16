package com.example.loteriaapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.loteriaapp.R
import com.example.loteriaapp.model.GetApuestaResponse
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by pacopulido on 9/10/18.
 */
class AdapterApuesta(val context: Context,
                     val layout: Int
) : RecyclerView.Adapter<AdapterApuesta.ViewHolder>() {

    private var dataList: List<GetApuestaResponse> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val viewlayout = layoutInflater.inflate(layout, parent, false)
        return ViewHolder(viewlayout, context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    internal fun setApuestas(apuestas: List<GetApuestaResponse>) {
        this.dataList = apuestas
        notifyDataSetChanged()
    }


    class ViewHolder(viewlayout: View, val context: Context) : RecyclerView.ViewHolder(viewlayout) {
        fun bind(dataItem: GetApuestaResponse){
            // itemview es el item de diseño
            // al que hay que poner los datos del objeto dataItem
            val tvSorteoDate = itemView.findViewById(R.id.tvSorteoDate) as TextView
            val tvCombinacion = itemView.findViewById(R.id.tvCombinacion) as TextView

            val pattern = "dd-MM-yyyy"
            val simpleDateFormat = SimpleDateFormat(pattern)
            val date: String = simpleDateFormat.format(dataItem.sorteo_date)


            tvSorteoDate.text = date
            tvCombinacion.text= dataItem.combinacion

            // foto de internet a traves de Picasso
           // Picasso.get().load("http://cdn.akamai.steamstatic.com/steam/apps/${dataItem.appid}/header.jpg").into(ivImagenGame)

            itemView.tag = dataItem

        }

    }
}