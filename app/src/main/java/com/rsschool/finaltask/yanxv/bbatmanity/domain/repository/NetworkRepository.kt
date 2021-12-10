package com.rsschool.finaltask.yanxv.bbatmanity.domain.repository

import com.rsschool.finaltask.yanxv.bbatmanity.domain.model.BelarusbankObject
import com.rsschool.finaltask.yanxv.bbatmanity.domain.model.BelarusbankRequestParam

interface NetworkRepository {

    suspend fun getBelarusbankATM(params: BelarusbankRequestParam): List<BelarusbankObject>

    suspend fun getBelarusbankInfobox(params: BelarusbankRequestParam): List<BelarusbankObject>

    suspend fun getBelarusbankFilial(params: BelarusbankRequestParam): List<BelarusbankObject>
}