package com.mintic.ticapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.mintic.ticapp.Modelos.PoisItem
import com.mintic.ticapp.R
import com.mintic.ticapp.ui.detail.Poi_info_completa
import com.squareup.picasso.Picasso

//Se hereda de recyclerview, se utiliza la propiedad adapter y se le pasa el viewholder encargado de pasar la información a poi
class PoisAdapter(private val poisList: ArrayList<PoisItem>, val contexto: FragmentManager) : RecyclerView.Adapter<PoisAdapter.ViewHolder>(){

    //Este método es para definir el layout en el que se va a trabajar, retorna el viewholder con las vista(el layout)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.poi, parent, false)
        return ViewHolder(view)

    }
    //Recibe un view holder y una posicion, hace un recorrido a la lista
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pois = poisList[position]
        holder.bind(pois, contexto)
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
        private var poiCardView: CardView = itemView.findViewById(R.id.poi_cardView)

        //Falta descripción
        fun bind(pois: PoisItem, contexto: FragmentManager){
            txtNombre.text = pois.nombreLugar
            txtTemperatura.text = "Temperatura: " + pois.temperatura
            txtPuntos.text =  "Puntuación: " + pois.puntuacion.toString() + " Estrellas"
            txtDescription.text = pois.descripcion.substring(0,60) + "..."
            //Falta descripción
            Picasso.get().load(pois.foto).into(imagenPoi);
            poiCardView.setOnClickListener {
                clickView(contexto, pois)
            }
        }

        private fun clickView(contexto: FragmentManager, pois: PoisItem){
            val transaction = contexto.beginTransaction()
            val newFragment = Poi_info_completa(pois)
            transaction.replace(R.id.main_container, newFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }

}