package com.example.alex_shirkovets_kode_trainee_2024.presentation

import androidx.compose.runtime.*

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.alex_shirkovets_kode_trainee_2024.presentation.KoderApplication
import com.example.alex_shirkovets_kode_trainee_2024.data.Employee
import com.example.alex_shirkovets_kode_trainee_2024.data.EmployeeRepository
import com.example.alex_shirkovets_kode_trainee_2024.domain.usecase.GetFilteredListUseCase
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


sealed interface AppUiState {
    data class Success(val listLoaded: List<Employee>) : AppUiState
    object Error : AppUiState
    object Loading : AppUiState
}
class AppViewModel (
    private val employeeRepository: EmployeeRepository
): ViewModel() {
    var appUiState: AppUiState by mutableStateOf(AppUiState.Loading)
        private set


    init {
        getLoadedList()
    }

    fun getLoadedList() {
        viewModelScope.launch {
            appUiState = AppUiState.Loading
            appUiState =
                try {
                    AppUiState.Success(employeeRepository
                        .getEmployees())
                } catch (e: IOException) {
                    AppUiState.Error
                } catch (e: HttpException) {
                    AppUiState.Error
                }
        }
    }


    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as KoderApplication)
                val employeeRepository = application.container.employeeRepository
                AppViewModel(employeeRepository = employeeRepository)
            }
        }
    }

    enum class SearchWidgetState {
        OPENED,
        CLOSED
    }

    private val _searchWidgetState: MutableState<SearchWidgetState> =
        mutableStateOf(value = SearchWidgetState.CLOSED)
    val searchWidgetState: MutableState<SearchWidgetState> = _searchWidgetState

    private val _searchTextState: MutableState<String> =
        mutableStateOf(value = "")
    val searchTextState: MutableState<String> = _searchTextState

    fun updateSearchWidgetState(newValue: SearchWidgetState) {
        _searchWidgetState.value = newValue
    }

    fun updateSearchTextState(newValue: String) {
        _searchTextState.value = newValue
    }



}

