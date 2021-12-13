package com.mintic.ticapp.data

class PoisRepository {

    suspend fun getPois() = ApiFactory.retrofit.getPois()
}