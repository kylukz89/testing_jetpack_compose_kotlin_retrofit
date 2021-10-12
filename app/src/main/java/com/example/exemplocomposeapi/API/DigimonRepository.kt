package com.example.exemplocomposeapi.API

import android.util.Log
import com.example.exemplocomposeapi.Response.DigimonList
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject


@ActivityScoped
class DigimonRepository @Inject constructor(private val api: DigimonAPI) {

    suspend fun getDigimonList(): DigimonList {
        try {
            return api.getDigimonList()
        } catch (e: Exception) {
            Log.d("error", e.message.toString())
        }
        return DigimonList()
    }

}