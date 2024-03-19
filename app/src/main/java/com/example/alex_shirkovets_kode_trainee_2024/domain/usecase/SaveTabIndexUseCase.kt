package com.example.alex_shirkovets_kode_trainee_2024.domain.usecase

import com.example.alex_shirkovets_kode_trainee_2024.domain.usecase.models.SaveFilterNameParam

class SaveFilterNameUseCase {
    fun execute(param: SaveFilterNameParam): Int {
        if (param.tabIndex == 0) {
            return 0
        } else {return param.tabIndex}
    }
}
