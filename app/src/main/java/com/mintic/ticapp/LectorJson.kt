package com.mintic.ticapp

import android.content.Context
import com.google.gson.Gson

class LectorJson {

    var contexto: Context

    constructor(contexto: Context){
        this.contexto = contexto
    }

    public fun loadMockPoisFromJscon(): ArrayList<PoisItem> {
        val poisString: String = contexto.assets.open("Lugares_Cancun.json").bufferedReader().use { it.readText() }
        val gson = Gson()
        val data = gson.fromJson(poisString, Pois::class.java)
        return data
    }
}