package com.istea.worldcup.pages.grupos

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.istea.worldcup.domain.Repository
import com.istea.worldcup.navigation.Router
import kotlinx.coroutines.launch

class GruposViewModel(
    private val repository: Repository,
    private val router: Router
) : ViewModel() {

    var uiState by mutableStateOf<GruposState>(GruposState.Vacio)

    init {
        onEvent(GruposIntention.Load)
    }

    fun onEvent(event: GruposIntention) {
        when (event) {
            GruposIntention.Load -> cargarContenido()
            is GruposIntention.OnGrupoClick -> goToGroupDetail(event.grupoId)
        }
    }

    private fun cargarContenido(){
        uiState = GruposState.Cargando
        viewModelScope.launch {
            val grupos = repository.getGroups()
            uiState = GruposState.Resultado(grupos)
        }
    }

    private fun goToGroupDetail(grupoId: String){
        router.openGroupDetail(grupoId)
    }
}

class GruposViewModelFactory(
    private val repositorio: Repository,
    private val router: Router
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GruposViewModel::class.java)) {
            return GruposViewModel(repositorio,router) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}