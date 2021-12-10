package com.rsschool.finaltask.yanxv.bbatmanity.application.di

import android.content.Context
import com.rsschool.finaltask.yanxv.bbatmanity.domain.di.DomainModule
import com.rsschool.finaltask.yanxv.bbatmanity.ui.di.UIComponent
import com.rsschool.finaltask.yanxv.bbatmanity.ui.di.UIModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DomainModule::class, UIModule::class])
interface ApplicationComponent {
    fun uiComponent(): UIComponent.Factory

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): ApplicationComponent
    }
}