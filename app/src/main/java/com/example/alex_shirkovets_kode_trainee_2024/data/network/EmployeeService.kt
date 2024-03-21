package com.example.alex_shirkovets_kode_trainee_2024.data.network

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface EmployeeService {

    @Headers("Accept: application/json, application/xml", "Prefer: code=200, example=success")

    @GET("/mocks/kode-api/trainee-test/331141861/users")
    suspend fun getEmployeesList(
    ): EmploeesList
}
