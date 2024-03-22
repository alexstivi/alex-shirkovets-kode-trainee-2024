package com.example.alex_shirkovets_kode_trainee_2024.domain.usecase

import com.example.alex_shirkovets_kode_trainee_2024.data.EmployeeRepository
import com.example.alex_shirkovets_kode_trainee_2024.domain.usecase.models.Employee

class GetFilteredListUseCase() {

    private var filteredList:List<Employee> = mutableListOf<Employee>()

    fun execute(filter: String, list: List<Employee>): List<Employee> {
        filteredList = list.filter { it -> it.firstName.contains(filter, ignoreCase = true)
                || it.lastName.contains(filter, ignoreCase = true)
                || it.userTag.contains(filter, ignoreCase = true)
        }
        return filteredList
    }
}