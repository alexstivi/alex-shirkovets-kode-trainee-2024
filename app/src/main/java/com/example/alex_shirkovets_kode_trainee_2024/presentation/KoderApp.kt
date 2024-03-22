package com.example.alex_shirkovets_kode_trainee_2024.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.alex_shirkovets_kode_trainee_2024.domain.usecase.GetFilteredListUseCase
import com.example.alex_shirkovets_kode_trainee_2024.domain.usecase.GetMappedListUseCase
import com.example.alex_shirkovets_kode_trainee_2024.domain.usecase.GetTabSortedListUseCase
import com.example.alex_shirkovets_kode_trainee_2024.domain.usecase.LoadActualListUseCase
import com.example.alex_shirkovets_kode_trainee_2024.presentation.screens.HomeScreen

val loadActualListUseCase = LoadActualListUseCase()
val getMappedListUseCase = GetMappedListUseCase()
val getFilteredListUseCase = GetFilteredListUseCase()
val getTabSortedListUseCase = GetTabSortedListUseCase()


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun KoderApp(
    modifier: Modifier = Modifier
) {
    val appViewModel: AppViewModel = viewModel(factory = AppViewModel.Factory)
    val searchWidgetState = appViewModel.searchWidgetState
    val searchTextState = appViewModel.searchTextState


    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            MainAppBar(
                searchWidgetState = searchWidgetState.value,
                searchTextState = searchTextState.value,
                onTextChange = {
                    appViewModel.updateSearchTextState(newValue = it)
                },
                onCloseClicked = {
                    appViewModel.updateSearchWidgetState(newValue = AppViewModel.SearchWidgetState.CLOSED)
                },
                onSearchClicked = {
                    appViewModel.getLoadedList()
                },
                onSearchTriggered = {
                    appViewModel.updateSearchWidgetState(newValue = AppViewModel.SearchWidgetState.OPENED)
                }
            )
        }
    ) {
        Surface(
            modifier = modifier
                .fillMaxSize()
                .padding(it),
            color = MaterialTheme.colorScheme.background
        ) {
            Column() {
                DepartmentNameTab()

                HomeScreen(
                    appUiState = appViewModel.appUiState,
                    retryAction = { appViewModel.getLoadedList() },
                    modifier = modifier
                )
            }
        }

    }
}

