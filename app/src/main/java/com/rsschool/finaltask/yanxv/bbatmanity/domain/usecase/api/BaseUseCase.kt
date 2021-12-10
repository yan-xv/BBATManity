package com.rsschool.finaltask.yanxv.bbatmanity.domain.usecase.api

import kotlinx.coroutines.flow.flow

abstract class BaseUseCase<Type, in Params> where Type : Any {

    abstract suspend fun run(params: Params): Type

    fun execute(params: Params) = flow {
        emit(run(params))
    }
}
