package com.mintic.ticapp.ui.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Parcel
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.mintic.ticapp.Modelos.PoisItem
import com.mintic.ticapp.R
import com.mintic.ticapp.ui.list.ListPoiFragment
import com.squareup.picasso.Picasso

class Poi_info_completa() : Fragment() {

    private lateinit var pois: PoisItem

    lateinit var titulo: TextView
    lateinit var imagen: ImageView
    lateinit var descripcion: TextView
    lateinit var temperatura: TextView
    lateinit var puntaje : TextView
    lateinit var btnUbicacion : ImageButton

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

        btnUbicacion.setOnClickListener {
            ubicacionGoogleMaps(pois)
        }

        return view
    }

    private fun inicializar(view: View) {
        titulo = view.findViewById<TextView>(R.id.titlePoi)
        imagen = view.findViewById<ImageView>(R.id.imageView)
        descripcion = view.findViewById<TextView>(R.id.txtDescripcion)
        temperatura = view.findViewById<TextView>(R.id.txtTemperatura)
        puntaje = view.findViewById<TextView>(R.id.txtPuntuacion)
        btnUbicacion = view.findViewById(R.id.btnUbicacion)
    }

    private fun ajustePoi(){
        titulo.text = pois.nombreLugar
        Picasso.get().load(pois.foto).into(imagen)
        descripcion.text = pois.descripcion
        temperatura.text = pois.temperatura
        puntaje.text = pois.puntuacion.toString() + " estrellas"
    }

    //   Abre la aplicación de Google Maps y coloca las coordenadas de la ubicación correspondiente.
    private fun ubicacionGoogleMaps(poi:PoisItem){
        val mapIntentUri = Uri.parse("geo:${poi.latitud},${poi.longitud}?z=15")
        val mapIntent = Intent(Intent.ACTION_VIEW, mapIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        context?.let { it1 ->
            mapIntent.resolveActivity(it1?.packageManager)?.let {
                startActivity(mapIntent)
            }
        }
    }

}