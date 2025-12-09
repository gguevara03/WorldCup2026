package com.istea.worldcup.pages.detalle

sealed class DetalleIntencion {
    object IrParaAtras : DetalleIntencion()
    object CargarContenido: DetalleIntencion()
}