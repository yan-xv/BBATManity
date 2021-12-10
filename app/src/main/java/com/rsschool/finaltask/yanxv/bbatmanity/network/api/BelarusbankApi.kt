package com.rsschool.finaltask.yanxv.bbatmanity.network.api

import com.rsschool.finaltask.yanxv.bbatmanity.network.model.BelarusbankAtmResponse
import com.rsschool.finaltask.yanxv.bbatmanity.network.model.BelarusbankFilialResponse
import com.rsschool.finaltask.yanxv.bbatmanity.network.model.BelarusbankInfoboxResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BelarusbankApi {
    @GET("atm")
    suspend fun getAllAtmByCity(@Query("city") city: String): List<BelarusbankAtmResponse>

    @GET("infobox")
    suspend fun getAllInfoboxByCity(@Query("city") city: String): List<BelarusbankInfoboxResponse>

    @GET("filials_info")
    suspend fun getAllFilialByCity(@Query("city") city: String): List<BelarusbankFilialResponse>
}