package com.mintic.ticapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

//Se hereda de recyclerview, se utiliza la propiedad adapter y se le pasa el viewholder encargado de pasar la información a poi
class PoisAdapter(private val poisList: ArrayList<PoisItem>) : RecyclerView.Adapter<PoisAdapter.ViewHolder>(){

    //Este método es para definir el layout en el que se va a trabajar, retorna el viewholder con las vista(el layout)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.poi, parent, false)
        return ViewHolder(view)

    }
    //Recibe un view holder y una posicion, hace un recorrido a la lista
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pois = poisList[position]
        holder.bind(pois)

    }

    override fun getItemCount(): Int {
        return poisList.size

    }
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private var txtNombre: TextView = itemView.findViewById(R.id.txtNombre)
        private var txtTemperatura: TextView = itemView.findViewById(R.id.txtTemperatura)
        private var txtPuntos: TextView = itemView.findViewById(R.id.txtPuntos)
        private var txtDescription: TextView = itemView.findViewById(R.id.txtDescription)
        private var imagenPoi: ImageView = itemView.findViewById(R.id.imagenPoi)
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