package com.mintic.ticapp.data


import com.mintic.ticapp.Modelos.Pois
import retrofit2.http.GET

interface APIService {
    @GET("pois/")
    suspend fun getPois(): Pois
}