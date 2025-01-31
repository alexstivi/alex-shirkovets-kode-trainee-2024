package com.example.alex_shirkovets_kode_trainee_2024.domain.usecase

import com.example.alex_shirkovets_kode_trainee_2024.data.DefaultAppContainer
import com.example.alex_shirkovets_kode_trainee_2024.data.Employee


class LoadActualListUseCase {

    suspend fun execute(): List<Employee> {

        val container = DefaultAppContainer()

        val booksRepository = container.employeeRepository

        return booksRepository
            .getEmployees()
    }
}