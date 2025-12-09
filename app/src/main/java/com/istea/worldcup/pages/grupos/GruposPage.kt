package com.istea.worldcup.pages.grupos

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.istea.worldcup.domain.RepositoryImpl
import com.istea.worldcup.navigation.RouterImpl

@Composable
fun GruposPage(
    navHostController: NavHostController,
    context: Context
) {
    val viewModel : GruposViewModel = viewModel(
        factory = GruposViewModelFactory(
            repositorio = RepositoryImpl(context),
            router = RouterImpl(navHostController),
        )
    )
    GruposView(
        state = viewModel.uiState,
        onAction = { intencion ->
            viewModel.onEvent(intencion)
        }
    )
}
