package com.mintic.ticapp.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.mintic.ticapp.LectorJson
import com.mintic.ticapp.Lugar_fragment
import com.mintic.ticapp.Modelos.PoisItem
import com.mintic.ticapp.R
import com.mintic.ticapp.ui.list.ListPoiFragment
import com.mintic.ticapp.ui.preference.FragmentosPreferencias

class MainActivity : AppCompatActivity(){
    lateinit var btnPoi: ImageButton
    lateinit var btnInfo: ImageButton
    lateinit var btnSetting: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var contexto: Context = this.applicationContext
        val lector = LectorJson(contexto)
        var pois: ArrayList<PoisItem> = lector.loadMockPoisFromJscon()

        val fragmentManager =  supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        btnPoi = findViewById(R.id.btnPoi)
        btnInfo = findViewById(R.id.btnInfoLugar)
        btnSetting = findViewById(R.id.btnSetting)

        val fragment = Lugar_fragment()
        fragmentTransaction.add(R.id.main_container, fragment)
        fragmentTransaction.commit()
        btnInfo.setBackgroundColor(resources.getColor(R.color.white))

        btnPoi.setOnClickListener {
            clickBtnPoi()
        }

        btnInfo.setOnClickListener {
            clickBtnInfo()
        }

        btnSetting.setOnClickListener {
            clickBtnSetting()
        }
    }

    /*private fun clickBtnPoi(pois: ArrayList<PoisItem>){
        val transaction = supportFragmentManager.beginTransaction()
        var fragmentManager = supportFragmentManager
        val newFragment = Poi_fragment(pois, fragmentManager)
        transaction.replace(R.id.main_container, newFragment)
        transaction.addToBackStack(null)
        transaction.commit()
        btnPoi.setBackgroundColor(resources.getColor(R.color.white))
        btnInfo.setBackgroundColor(resources.getColor(R.color.ic_paisaje_background))
        btnSetting.setBackgroundColor(resources.getColor(R.color.ic_paisaje_background))
    }*/

    private fun clickBtnPoi(){
        val transaction = supportFragmentManager.beginTransaction()
        val newFragment = ListPoiFragment()
        transaction.replace(R.id.main_container, newFragment)
        transaction.addToBackStack(null)
        transaction.commit()
        btnPoi.setBackgroundColor(resources.getColor(R.color.white))
        btnInfo.setBackgroundColor(resources.getColor(R.color.ic_paisaje_background))
        btnSetting.setBackgroundColor(resources.getColor(R.color.ic_paisaje_background))
    }

    private fun clickBtnInfo(){
        val transaction = supportFragmentManager.beginTransaction()
        val newFragment = Lugar_fragment()
        transaction.replace(R.id.main_container, newFragment)
        transaction.addToBackStack(null)
        transaction.commit()
        btnPoi.setBackgroundColor(resources.getColor(R.color.ic_paisaje_background))
        btnInfo.setBackgroundColor(resources.getColor(R.color.white))
        btnSetting.setBackgroundColor(resources.getColor(R.color.ic_paisaje_background))
    }

    private fun clickBtnSetting(){
        val transaction = supportFragmentManager.beginTransaction()
        val newFragment = FragmentosPreferencias()
        transaction.replace(R.id.main_container, newFragment)
        transaction.addToBackStack(null)
        transaction.commit()
        btnPoi.setBackgroundColor(resources.getColor(R.color.ic_paisaje_background))
        btnSetting.setBackgroundColor(resources.getColor(R.color.white))
        btnInfo.setBackgroundColor(resources.getColor(R.color.ic_paisaje_background))
    }

}


