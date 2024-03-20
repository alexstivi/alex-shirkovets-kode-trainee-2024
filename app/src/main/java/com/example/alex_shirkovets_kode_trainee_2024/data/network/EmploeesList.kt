package com.example.alex_shirkovets_kode_trainee_2024.data.network

import com.google.gson.annotations.SerializedName

data class EmploeesList {
    @SerializedName("items") val items : List<Items> = listOf()
}
