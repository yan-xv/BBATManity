package com.rsschool.finaltask.yanxv.bbatmanity.domain.model

data class BelarusbankRequestParam (
    val city: String,
    val targetLat: Double = 0.0,
    val targetLng: Double = 0.0,
    val countObject: Int = 0
)