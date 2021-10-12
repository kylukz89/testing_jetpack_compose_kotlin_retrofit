package com.example.exemplocomposeapi.Listagem

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exemplocomposeapi.API.DigimonRepository
import com.example.exemplocomposeapi.Response.DigimonListItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DigimonListViewModel @Inject constructor(
    private val repository: DigimonRepository
) : ViewModel() {

    val digimonList = mutableStateOf<List<DigimonListItem>>(listOf())

    // função executada sempre que chamamos a viewmodel
    init {
        loadDigimons()
    }

    fun loadDigimons() {
        viewModelScope.launch {
            digimonList.value = repository.getDigimonList()
        }
    }
}