package com.rsschool.finaltask.yanxv.bbatmanity.domain.model

abstract class BelarusbankObject {
    abstract val streetType: String
    abstract val street: String
    abstract val homeNumber: String
    abstract val lat: Double
    abstract val lng: Double

    open val workTime: String = ""
    open val installPlace: String = ""
    open val filialName: String = ""

    var typeObject: String = ""
    val isOpenNow = true
    val getFullAddress
        get() = "$streetType $street, $homeNumber"
}
