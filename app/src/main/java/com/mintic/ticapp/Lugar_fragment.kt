package com.mintic.ticapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView


class Lugar_fragment : Fragment() {
    lateinit var layoutMexico: LinearLayout
    lateinit var txtMexico: TextView
    lateinit var btnUbicacion: Button
    lateinit var btnClima: Button
    lateinit var btnTurismo: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.layout_lugar_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        inicializar(view)


        txtMexico.text = resources.getText(R.string.info_ubicacion_mexico)

        btnUbicacion.setOnClickListener {
            onClickBtnUbicacion()
        }
        btnClima.setOnClickListener {
            onClickBtnClima()
        }
        btnTurismo.setOnClickListener {
            onClickBtnTurismo()
        }
    }

    private fun inicializar(view: View){
        layoutMexico = view.findViewById(R.id.layout_info_mexico)
        btnUbicacion = view.findViewById(R.id.btn_ubicacion_mexico)
        btnClima = view.findViewById(R.id.btn_clima_mexico)
        btnTurismo = view.findViewById(R.id.btn_turismo_mexico)
        txtMexico = view.findViewById(R.id.txt_info_ubicacion_mexico)
    }

    private fun onClickBtnUbicacion(){
        txtMexico.text = resources.getText(R.string.info_ubicacion_mexico)
        layoutMexico.background = btnUbicacion.background
    }

    private fun onClickBtnClima(){
        txtMexico.text = resources.getText(R.string.info_clima_mexico)
        layoutMexico.background = btnClima.background
    }

    private fun onClickBtnTurismo(){
        txtMexico.text = resources.getText(R.string.info_turismo_mexico)
        layoutMexico.background = btnTurismo.background
    }
}