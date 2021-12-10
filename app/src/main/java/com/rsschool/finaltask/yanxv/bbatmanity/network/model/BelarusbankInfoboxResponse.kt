package com.rsschool.finaltask.yanxv.bbatmanity.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.rsschool.finaltask.yanxv.bbatmanity.domain.model.BelarusbankObject

@JsonClass(generateAdapter = true)
class BelarusbankInfoboxResponse (
    @field:Json(name = "info_id")
    val id: Int,
    @field:Json(name = "address_type")
    override val streetType: String,
    @field:Json(name = "address")
    override val street: String,
    @field:Json(name = "house")
    override val homeNumber: String,
    @field:Json(name = "install_place")
    override val installPlace: String,
    @field:Json(name = "location_name_desc")
    val locationNameDesc: String,
    @field:Json(name = "work_time")
    override val workTime: String,
    @field:Json(name = "time_long")
    val timeLong: String,
    @field:Json(name = "gps_x")
    override val lat: Double,
    @field:Json(name = "gps_y")
    override val lng: Double,
    @field:Json(name = "inf_status")
    val infStatus: String
) : BelarusbankObject()