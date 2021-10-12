package com.example.exemplocomposeapi.API

import com.example.exemplocomposeapi.Response.DigimonList
import retrofit2.http.GET

//
interface DigimonAPI {

    @GET("digimon")
    suspend fun getDigimonList(): DigimonList

}