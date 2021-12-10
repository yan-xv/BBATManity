package com.rsschool.finaltask.yanxv.bbatmanity.storage.di

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.rsschool.finaltask.yanxv.bbatmanity.domain.repository.SettingsMapRepository
import com.rsschool.finaltask.yanxv.bbatmanity.storage.repository.SettingsMapRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class StorageModule {

    @Provides
    fun settingsRepositoryMapImpl(
        sharedPreferences: SharedPreferences,
        context: Context
    ): SettingsMapRepository {
        return SettingsMapRepositoryImpl(sharedPreferences, context)
    }

    @Provides
    fun sharedPreferences(context: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }
}