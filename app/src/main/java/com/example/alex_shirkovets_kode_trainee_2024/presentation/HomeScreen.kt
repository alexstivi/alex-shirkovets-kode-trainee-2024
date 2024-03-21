package com.example.alex_shirkovets_kode_trainee_2024.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(
    appUiState: AppUiState,
    retryAction: () -> Unit,
    modifier: Modifier
) {
    when (appUiState) {
        is AppUiState.Loading -> LoadingScreen(modifier)
        is AppUiState.Success -> EmployeesList(
            list = appUiState.listLoaded,
            modifier = modifier
        )
        is AppUiState.Error -> ErrorScreen(retryAction = retryAction, modifier)
    }
}