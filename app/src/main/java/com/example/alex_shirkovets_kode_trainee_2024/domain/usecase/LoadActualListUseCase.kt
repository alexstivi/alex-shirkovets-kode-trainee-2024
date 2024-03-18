package com.example.alex_shirkovets_kode_trainee_2024.domain.usecase


import com.example.alex_shirkovets_kode_trainee_2024.domain.usecase.models.Employee
import com.example.alex_shirkovets_kode_trainee_2024.domain.usecase.models.EmployeesSampleData
import com.example.alex_shirkovets_kode_trainee_2024.presentation.models.EmployeesNamesSampleData


class LoadActualListUseCase() {
    val EmployeesSample = EmployeesSampleData.employees

    fun execute(): List<Employee> {

        return EmployeesSample
    }
}