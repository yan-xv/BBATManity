package com.rsschool.finaltask.yanxv.bbatmanity.domain.usecase.settings

import com.rsschool.finaltask.yanxv.bbatmanity.domain.repository.SettingsMapRepository
import javax.inject.Inject

class SetSettingsMapUseCase @Inject constructor(
    private val settingsMapRepository: SettingsMapRepository
) {

    fun execute(settingsMap: Map<String, Any>) {
        return settingsMapRepository.setSettingsMap(settingsMap)
    }
}
