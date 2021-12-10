package com.rsschool.finaltask.yanxv.bbatmanity.ui.model

import com.google.android.gms.maps.model.LatLng
import com.rsschool.finaltask.yanxv.bbatmanity.domain.model.BelarusbankObject

data class MarkerMap (
    val latLng: LatLng,
    val isOpen: Boolean,
    val workTime: String,
    val address: String,
    val installPlace: String,
    val typeObject: String
) {
    constructor(belarusbankObject: BelarusbankObject) :
        this (
            latLng = LatLng(belarusbankObject.lat, belarusbankObject.lng),
            isOpen = belarusbankObject.isOpenNow,
            workTime = belarusbankObject.workTime,
            address = belarusbankObject.getFullAddress,
            installPlace = belarusbankObject.installPlace,
            typeObject = belarusbankObject.typeObject
        )
}
