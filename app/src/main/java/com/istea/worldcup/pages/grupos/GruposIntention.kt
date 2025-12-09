package com.istea.worldcup.pages.grupos

sealed interface GruposIntention {
    data object Load : GruposIntention
    data class OnGrupoClick(val grupoId: String) : GruposIntention
}