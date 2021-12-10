package com.rsschool.finaltask.yanxv.bbatmanity.domain.usecase.api

import com.rsschool.finaltask.yanxv.bbatmanity.domain.model.BelarusbankObject
import com.rsschool.finaltask.yanxv.bbatmanity.domain.model.BelarusbankRequestParam
import com.rsschool.finaltask.yanxv.bbatmanity.domain.repository.NetworkRepository
import javax.inject.Inject

class GetBelarusbankFilialUseCase @Inject constructor (private val networkRepository: NetworkRepository) :
    BaseUseCase<List<BelarusbankObject>, BelarusbankRequestParam>() {

    override suspend fun run(params: BelarusbankRequestParam): List<BelarusbankObject> {
        return networkRepository.getBelarusbankFilial(params)
    }
}
