package com.mintic.ticapp.Modelos


import com.google.gson.annotations.SerializedName

data class PoisItem(
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("foto")
    val foto: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("nombre_lugar")
    val nombreLugar: String,
    @SerializedName("puntuacion")
    val puntuacion: Int,
    @SerializedName("temperatura")
    val temperatura: String,
    @SerializedName("latitud")
    val latitud: Double,
    @SerializedName("longitud")
    val longitud: Double
)