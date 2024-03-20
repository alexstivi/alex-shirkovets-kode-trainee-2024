package com.example.alex_shirkovets_kode_trainee_2024.data.network

import com.google.gson.annotations.SerializedName

data class Items {
    @SerializedName("id") val id : String? = null,
    @SerializedName("avatarUrl") val avatarUrl : String? = null,
    @SerializedName("firstName") val firstName : String? = null,
    @SerializedName("lastName") val lastName : String? = null,
    @SerializedName("userTag") val userTag : String? = null,
    @SerializedName("department") val department : String? = null,
    @SerializedName("position") val position : String? = null,
    @SerializedName("birthday") val birthday : String? = null,
    @SerializedName("phone") val phone : String? = null
}