package com.mintic.ticapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson

class ListPOIActivity : AppCompatActivity() {

    private lateinit  var listpois: ArrayList<PoisItem>
    private lateinit var poisAdapter: PoisAdapter
    private lateinit var poisRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_poiactivity)
        poisRecyclerView = findViewById(R.id.poi_recyclerview)
       // listpois = createMockPois()
        listpois = loadMockPoisFromJscon()

        //poisRecyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        poisRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = poisAdapter
            setHasFixedSize(false)
        }
        //poisRecyclerView.adapter = poisAdapter
    }

    private fun loadMockPoisFromJscon(): ArrayList<PoisItem> {
        val poisString: String = applicationContext.assets.open("Lugares_Cancun.json").bufferedReader().use { it.readText() }
        val gson = Gson()
        val data = gson.fromJson(poisString, Pois::class.java)
        return data


    }
    /*
    private fun createMockPois() : ArrayList<Pois>{
        return arrayListOf(
            Pois(
                nombre = "Cancún",
                temperatura = "30°C",
                puntuacion = "4 estrellas",
                descripcion = "Cancún es una playa de México",
                urlImagen = "https://alkilautos.com/blog/wp-content/uploads/2017/06/19.02.15-Playas-publicas-de-Cancun-770x515.jpg"
            ),
            Pois(
                nombre = "Ciudad de México",
                temperatura = "25°C",
                puntuacion = "3 estrellas",
                descripcion = "Ciudad de México es la capital de México",
                urlImagen = "https://content.r9cdn.net/rimg/dimg/9b/2d/0aeefb46-city-53588-1643df9f219.jpg"
            ),
            Pois(
                nombre = "Playa del Carmen",
                temperatura = "25°C",
                puntuacion = "5 estrellas",
                descripcion = "Playa del Carmen es es una playa de México",
                urlImagen = "https://imagenescityexpress.scdn6.secure.raxcdn.com/sites/default/files/2017-05/que-hacer-playa-del-carmen1.jpg"
            )
        )
    }*/
}