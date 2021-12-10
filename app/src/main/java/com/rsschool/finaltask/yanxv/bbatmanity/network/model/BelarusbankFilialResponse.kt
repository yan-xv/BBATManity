package com.rsschool.finaltask.yanxv.bbatmanity.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.rsschool.finaltask.yanxv.bbatmanity.domain.model.BelarusbankObject

@JsonClass(generateAdapter = true)
class BelarusbankFilialResponse (
    @field:Json(name = "filial_id")
    val id: Int,
    @field:Json(name = "street_type")
    override val streetType: String,
    @field:Json(name = "street")
    override val street: String,
    @field:Json(name = "home_number")
    override val homeNumber: String,
    @field:Json(name = "info_text")
    override val installPlace: String,
    @field:Json(name = "filial_name")
    override val filialName: String,
    @field:Json(name = "info_worktime")
    val workTimeFull: String,
    @field:Json(name = "GPS_X")
    override val lat: Double,
    @field:Json(name = "GPS_Y")
    override val lng: Double
) : BelarusbankObject()