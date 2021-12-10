package com.rsschool.finaltask.yanxv.bbatmanity.storage.repository

import android.content.Context
import android.content.SharedPreferences
import com.rsschool.finaltask.yanxv.bbatmanity.R
import com.rsschool.finaltask.yanxv.bbatmanity.domain.repository.SettingsMapRepository

class SettingsMapRepositoryImpl(
    private val sharedPreferences: SharedPreferences,
    private val context: Context
) : SettingsMapRepository {

    override fun setSettingsMap(settings: Map<String, Any>) {

        settings.forEach { (key, value) ->
            when (value) {
                is String -> {
                    sharedPreferences.edit().putString(key, value).apply()
                }
                is Boolean -> {
                    sharedPreferences.edit().putBoolean(key, value).apply()
                }
            }
        }
    }

    override fun getSettingsMap(): Map<String, Any> {

        val settingsMap = mutableMapOf<String, Any>()

        sharedPreferences.all.forEach { (key, value) ->
            when (value) {
                is String -> {
                    settingsMap[key] = sharedPreferences.getString(key, "") ?: ""
                }
                is Boolean -> {
                    settingsMap[key] = sharedPreferences.getBoolean(key, true)
                }
            }
        }

        return settingsMap
    }

    override fun getSettingsMapCity(): String {
        return sharedPreferences.getString(
            context.getString(R.string.city_list_key),
            context.getString(R.string.city_list_default),
        ) ?: ""
    }

    override fun isEnabledATM(): Boolean {
        return sharedPreferences.getBoolean(context.getString(R.string.atm_switcher_key), true)
    }

    override fun isEnabledInfobox(): Boolean {
        return sharedPreferences.getBoolean(context.getString(R.string.infobox_switcher_key), true)
    }

    override fun isEnabledFilial(): Boolean {
        return sharedPreferences.getBoolean(context.getString(R.string.filial_switcher_key), true)
    }
}