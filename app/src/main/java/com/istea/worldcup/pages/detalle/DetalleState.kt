package com.istea.worldcup.pages.detalle

import com.istea.worldcup.domain.Group

sealed class DetalleState {
    data object Vacio: DetalleState()
    data object Cargando: DetalleState()
    data class Resultado(val grupo: Group) :DetalleState()
    data class Error(val mensaje: String): DetalleState()
}