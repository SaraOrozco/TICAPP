package com.mintic.ticapp.ui.detail

import android.os.Bundle
import android.os.Parcel
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.mintic.ticapp.Modelos.PoisItem
import com.mintic.ticapp.R
import com.squareup.picasso.Picasso

class Poi_info_completa() : Fragment() {

    private lateinit var pois: PoisItem

    lateinit var titulo: TextView
    lateinit var imagen: ImageView
    lateinit var descripcion: TextView
    lateinit var temperatura: TextView
    lateinit var puntaje : TextView

    constructor(parcel: Parcel) : this() {

    }

    constructor(pois: PoisItem) : this() {
        this.pois = pois
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.poi_fragment, container, false)

        inicializar(view)
        ajustePoi()

        return view
    }

    private fun inicializar(view: View) {
        titulo = view.findViewById<TextView>(R.id.titlePoi)
        imagen = view.findViewById<ImageView>(R.id.imageView)
        descripcion = view.findViewById<TextView>(R.id.txtDescripcion)
        temperatura = view.findViewById<TextView>(R.id.txtTemperatura)
        puntaje = view.findViewById<TextView>(R.id.txtPuntuacion)
    }

    private fun ajustePoi(){
        titulo.text = pois.nombreLugar
        Picasso.get().load(pois.foto).into(imagen)
        descripcion.text = pois.descripcion
        temperatura.text = pois.temperatura
        puntaje.text = pois.puntuacion.toString() + " estrellas"
    }

}