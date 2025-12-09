package com.istea.worldcup.pages.grupos

import com.istea.worldcup.domain.Group

sealed class GruposState {
    data object Vacio: GruposState()
    data object Cargando: GruposState()
    data class Resultado(
        val grupos : List<Group>
    ) :GruposState()
}