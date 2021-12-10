package com.rsschool.finaltask.yanxv.bbatmanity.ui.di

import com.rsschool.finaltask.yanxv.bbatmanity.ui.map.ActivityScope
import com.rsschool.finaltask.yanxv.bbatmanity.ui.map.MapsActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface UIComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): UIComponent
    }

    fun inject(activity: MapsActivity)
}