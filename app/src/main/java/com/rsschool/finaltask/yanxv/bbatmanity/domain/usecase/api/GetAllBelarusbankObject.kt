package com.rsschool.finaltask.yanxv.bbatmanity.domain.usecase.api

import com.rsschool.finaltask.yanxv.bbatmanity.domain.model.BelarusbankObject
import com.rsschool.finaltask.yanxv.bbatmanity.domain.model.BelarusbankRequestParam
import com.rsschool.finaltask.yanxv.bbatmanity.domain.repository.NetworkRepository
import com.rsschool.finaltask.yanxv.bbatmanity.domain.repository.SettingsMapRepository
import javax.inject.Inject

class GetBelarusbankCustomUseCase @Inject constructor(
    private val networkRepository: NetworkRepository,
    private val settingsMapRepository: SettingsMapRepository
) : BaseUseCase<List<BelarusbankObject>, BelarusbankRequestParam>() {

    override suspend fun run(params: BelarusbankRequestParam): List<BelarusbankObject> {

        val list = mutableListOf<BelarusbankObject>()

        if (settingsMapRepository.isEnabledATM())
            list.addAll(networkRepository.getBelarusbankATM(params))

        if (settingsMapRepository.isEnabledFilial())
            list.addAll(networkRepository.getBelarusbankInfobox(params))

        if (settingsMapRepository.isEnabledFilial())
            list.addAll(networkRepository.getBelarusbankFilial(params))
        return list
    }
}