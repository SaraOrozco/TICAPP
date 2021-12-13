package com.mintic.ticapp.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.mintic.ticapp.Modelos.PoisItem
import com.mintic.ticapp.R
import com.squareup.picasso.Picasso

class ListPoisAdapter(private val poisList: ArrayList<PoisItem>,
private val onItemClicked: (PoisItem) -> Unit): RecyclerView.Adapter<ListPoisAdapter.PoisViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PoisViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.poi, parent, false)
        return PoisViewHolder(view)
    }

    override fun onBindViewHolder(holder: PoisViewHolder, position: Int) {
        val pois = poisList[position]
        holder.itemView.setOnClickListener{ onItemClicked(poisList[position])}
        holder.bind(pois)
    }

    override fun getItemCount(): Int = poisList.size

    fun appendItems(newItems: ArrayList<PoisItem>) {
        poisList.clear()
        poisList.addAll(newItems)
        notifyDataSetChanged()
    }

    class PoisViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private var txtNombre: TextView = itemView.findViewById(R.id.txtNombre)
        private var txtTemperatura: TextView = itemView.findViewById(R.id.txtTemperatura)
        private var txtPuntos: TextView = itemView.findViewById(R.id.txtPuntos)
        private var txtDescription: TextView = itemView.findViewById(R.id.txtDescription)
        private var imagenPoi: ImageView = itemView.findViewById(R.id.imagenPoi)
        private var poiCardView: CardView = itemView.findViewById(R.id.poi_cardView)

        //Falta descripción
        fun bind(pois: PoisItem){
            txtNombre.text = pois.nombreLugar
            txtTemperatura.text = "Temperatura: " + pois.temperatura
            txtPuntos.text =  "Puntuación: " + pois.puntuacion.toString() + " Estrellas"
            txtDescription.text = pois.descripcion.substring(0,60) + "..."
            //Falta descripción
            Picasso.get().load(pois.foto).into(imagenPoi);

        }
    }
}