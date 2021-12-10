package com.rsschool.finaltask.yanxv.bbatmanity.domain.usecase.settings

import com.rsschool.finaltask.yanxv.bbatmanity.domain.repository.SettingsMapRepository
import javax.inject.Inject

class GetSettingsMapCityUseCase @Inject constructor(
    private val settingsMapRepository: SettingsMapRepository
) {

    fun execute(): String {
        return settingsMapRepository.getSettingsMapCity()
    }
}