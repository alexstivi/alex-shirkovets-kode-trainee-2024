package com.example.alex_shirkovets_kode_trainee_2024.data

import com.example.alex_shirkovets_kode_trainee_2024.data.network.EmployeeService
import retrofit2.http.Header

interface EmployeeRepository {
    suspend fun getEmployees(): List<Employee>
}

class NetworkEmployeeRepository(
    private val employeeService: EmployeeService
) : EmployeeRepository {
    override suspend fun getEmployees(): List<Employee> = employeeService
        .getEmployeesList().items.map { items ->
            Employee(
                id = items.id,
                avatarUrl = items.avatarUrl,
                firstName = items.firstName,
                lastName = items.lastName,
                userTag = items.userTag,
                department = items.department,
                position = items.position,
                birthday = items.birthday,
                phone = items.phone
            )
        }
}
