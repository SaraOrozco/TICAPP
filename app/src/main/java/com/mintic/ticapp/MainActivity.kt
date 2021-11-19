package com.mintic.ticapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager =  supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val btnPoi = findViewById<ImageButton>(R.id.btnPoi)
        val btnInfo = findViewById<ImageButton>(R.id.btnInfoLugar)

        val fragment = Lugar_fragment()
        fragmentTransaction.add(R.id.main_container, fragment)
        fragmentTransaction.commit()

        btnPoi.setOnClickListener {
            clickBtnPoi()
        }

        btnInfo.setOnClickListener {
            clickBtnInfo()
        }
    }

    private fun clickBtnPoi(){
        val transaction = supportFragmentManager.beginTransaction()
        val newFragment = Poi_fragment()
        transaction.replace(R.id.main_container, newFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun clickBtnInfo(){
        val transaction = supportFragmentManager.beginTransaction()
        val newFragment = Lugar_fragment()
        transaction.replace(R.id.main_container, newFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}