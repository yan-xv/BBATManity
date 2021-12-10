package com.rsschool.finaltask.yanxv.bbatmanity.domain.repository

interface SettingsMapRepository {

    fun setSettingsMap(settings: Map<String, Any>)

    fun getSettingsMap(): Map<String, Any>

    fun getSettingsMapCity(): String

    fun isEnabledATM(): Boolean

    fun isEnabledInfobox(): Boolean

    fun isEnabledFilial(): Boolean
}