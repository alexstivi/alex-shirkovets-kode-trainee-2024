package com.example.alex_shirkovets_kode_trainee_2024.domain.usecase

import androidx.compose.runtime.Composable


class GetMappedListUseCase {
   
    @Composable
    fun execute (list: List<String>, map: Map<String, String>) : List<String> {
        val myMutable = mutableListOf("Все")
        for (names in list) {
            val key: String? = map[names]
            if (key != null) {
                myMutable.add(key)
            }
        }
        return myMutable
    }

}