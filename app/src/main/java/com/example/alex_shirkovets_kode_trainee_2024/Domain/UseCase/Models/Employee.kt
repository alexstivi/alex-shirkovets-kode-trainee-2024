package com.example.alex_shirkovets_kode_trainee_2024.Domain.UseCase.Models

data class Employee (
        val id: String,
        val avatarUrl: String,
        val firstName: String,
        val lastName: String,
        val userTag: String,
        val department: String,
        val position: String,
        val birthday: String,
        val phone: String
)
