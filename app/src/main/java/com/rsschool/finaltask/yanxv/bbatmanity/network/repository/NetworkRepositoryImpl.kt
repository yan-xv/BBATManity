package com.rsschool.finaltask.yanxv.bbatmanity.network.repository

import com.rsschool.finaltask.yanxv.bbatmanity.network.api.BelarusbankApi
import com.rsschool.finaltask.yanxv.bbatmanity.domain.model.BelarusbankRequestParam
import com.rsschool.finaltask.yanxv.bbatmanity.domain.model.BelarusbankObject
import com.rsschool.finaltask.yanxv.bbatmanity.domain.repository.NetworkRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkRepositoryImpl @Inject constructor(
    private val belarusbankApi: BelarusbankApi) :
    NetworkRepository {

    override suspend fun getBelarusbankATM(params: BelarusbankRequestParam): List<BelarusbankObject> {
        return castResponseToObject(belarusbankApi.getAllAtmByCity(params.city))
            .onEach { it.typeObject = "АТМ" }
    }

    override suspend fun getBelarusbankInfobox(params: BelarusbankRequestParam): List<BelarusbankObject> {
        return castResponseToObject(belarusbankApi.getAllInfoboxByCity(params.city))
            .onEach { it.typeObject = "Инфокиоск" }
    }

    override suspend fun getBelarusbankFilial(params: BelarusbankRequestParam): List<BelarusbankObject> {
        return castResponseToObject(belarusbankApi.getAllFilialByCity(params.city))
            .onEach { it.typeObject = "Отделение" }
    }

    private fun <T>castResponseToObject(list: List<T>): List<BelarusbankObject> {
        return list.filterIsInstance<BelarusbankObject>()
            .apply { if (size != list.size) emptyList<BelarusbankObject>() }
    }
}
