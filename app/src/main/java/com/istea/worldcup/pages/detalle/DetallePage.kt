package com.istea.worldcup.pages.detalle

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.istea.worldcup.domain.RepositoryImpl
import com.istea.worldcup.navigation.RouterImpl
import com.istea.worldcup.pages.grupos.GruposView
import com.istea.worldcup.pages.grupos.GruposViewModel
import com.istea.worldcup.pages.grupos.GruposViewModelFactory

@Composable
fun DetallePage(
    navHostController: NavHostController,
    context: Context,
    groupID: String
) {
    val viewModel : DetalleViewModel = viewModel(
        factory = DetalleViewModelFactory(
            repositorio = RepositoryImpl(context),
            router = RouterImpl(navHostController),
            groupID = groupID
        )
    )
    DetalleView(
        state = viewModel.uiState,
        onAction = { intencion ->
            viewModel.ejecutar(intencion)
        }
    )
}