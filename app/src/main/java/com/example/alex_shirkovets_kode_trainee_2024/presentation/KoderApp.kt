package com.example.alex_shirkovets_kode_trainee_2024.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun KoderApp(
    modifier: Modifier = Modifier
) {
    val appViewModel : AppViewModel = viewModel(factory = AppViewModel.Factory)

    Surface(modifier = modifier
        .fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        HomeScreen(
            appUiState = appViewModel.appUiState,
            retryAction = { appViewModel.getLoadedList() },
            modifier = modifier
        )
    }
}