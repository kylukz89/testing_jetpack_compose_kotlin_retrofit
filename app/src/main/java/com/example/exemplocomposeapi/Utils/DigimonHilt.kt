package com.example.exemplocomposeapi.Utils

import android.app.Application
import com.example.exemplocomposeapi.API.DigimonAPI
import com.example.exemplocomposeapi.API.DigimonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@HiltAndroidApp
class DigimonHilt: Application() {

}

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDigimonRepository(api: DigimonAPI) = DigimonRepository(api)

    @Singleton
    @Provides
    fun providerDigimonAPI() : DigimonAPI {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://digimon-api.vercel.app/api/")
            .build()
            .create(DigimonAPI::class.java)
    }

}