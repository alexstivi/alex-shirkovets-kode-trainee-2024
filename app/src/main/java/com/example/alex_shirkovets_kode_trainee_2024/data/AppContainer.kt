package com.example.alex_shirkovets_kode_trainee_2024.data

import com.example.alex_shirkovets_kode_trainee_2024.data.network.EmployeeService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {
    val employeeRepository: EmployeeRepository
}

class DefaultAppContainer : AppContainer {
    private val BASE_URL = "https://stoplight.io"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val retrofitService: EmployeeService by lazy {
        retrofit.create(EmployeeService::class.java)
    }

    override val employeeRepository: EmployeeRepository by lazy {
      NetworkEmployeeRepository(retrofitService)
    }
}