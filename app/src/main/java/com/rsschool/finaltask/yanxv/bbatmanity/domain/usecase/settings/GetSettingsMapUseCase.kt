package com.rsschool.finaltask.yanxv.bbatmanity.domain.usecase.settings

import com.rsschool.finaltask.yanxv.bbatmanity.domain.repository.SettingsMapRepository
import javax.inject.Inject

class GetSettingsMapUseCase @Inject constructor(
    private val settingsMapRepository: SettingsMapRepository
) {

    fun execute(): Map<String, Any> {
        return settingsMapRepository.getSettingsMap()
    }
}