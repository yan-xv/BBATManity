package com.rsschool.finaltask.yanxv.bbatmanity.application

import android.app.Application
import com.rsschool.finaltask.yanxv.bbatmanity.application.di.ApplicationComponent
import com.rsschool.finaltask.yanxv.bbatmanity.application.di.DaggerApplicationComponent

class App: Application() {

    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.builder()
            .context(context = this)
            .build()
    }
}