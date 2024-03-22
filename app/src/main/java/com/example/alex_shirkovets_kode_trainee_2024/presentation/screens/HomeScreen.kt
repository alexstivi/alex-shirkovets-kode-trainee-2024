package com.example.alex_shirkovets_kode_trainee_2024.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.alex_shirkovets_kode_trainee_2024.presentation.AppUiState

@Composable
fun HomeScreen(
    appUiState: AppUiState,
    retryAction: () -> Unit,
    modifier: Modifier,
) {
    when (appUiState) {
        is AppUiState.Loading -> LoadingScreen(modifier)
        is AppUiState.Success -> EmployeesListScreen(
            list = appUiState.listLoaded,
            modifier = modifier)
        is AppUiState.Error -> ErrorScreen(retryAction = retryAction, modifier)
    }
}