package com.rsschool.finaltask.yanxv.bbatmanity.ui.utils

object ReferenceCityPosition {
    private val listCityPosition = mapOf<String, Pair<Double, Double>>(
        ("Минск"    to (53.9023622868706 to 27.5459842313872)),
        ("Брест"    to (52.1014155275472 to 23.7173015653631)),
        ("Витебск"  to (55.1847467438373 to 30.2089688912999)),
        ("Гомель"   to (52.4215246954938 to 31.0162089881013)),
        ("Гродно"   to (53.6734514620095 to 23.8240661166141)),
        ("Могилев"  to (53.8964064342918 to 30.3349539227948))
    )

    private fun findLatLngByCity(city: String): Pair<Double, Double> {
        listCityPosition.forEach {
            if ( it.key == city)
             return it.value
        }

        return 0.0 to 0.0
    }

    fun getLatByCity(city: String): Double = findLatLngByCity(city).first

    fun getLngByCity(city: String): Double = findLatLngByCity(city).second
}