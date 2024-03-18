package com.example.alex_shirkovets_kode_trainee_2024.domain.usecase

import com.example.alex_shirkovets_kode_trainee_2024.domain.usecase.models.Employee

class GetTabSortedListUseCase {

private var sortedList:List<Employee> = mutableListOf<Employee>()

    fun execute(tab: String, list:List<Employee>): List<Employee> {
        sortedList = list.filter { it -> it.department == tab }

        return sortedList
    }
}