package com.example.alex_shirkovets_kode_trainee_2024.data.network

import com.example.alex_shirkovets_kode_trainee_2024.data.Employee
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface EmployeeService {
    @Headers(
        "Accept: application/json, application/xml"
    )
    @GET("items")
    suspend fun getEmployeesList(
        @Query("q") searchQuery: String,
        @Query("maxResults") maxResults: Int
    ): Employee
}