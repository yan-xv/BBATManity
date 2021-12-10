package com.rsschool.finaltask.yanxv.bbatmanity.domain.di

import com.rsschool.finaltask.yanxv.bbatmanity.storage.di.StorageModule
import com.rsschool.finaltask.yanxv.bbatmanity.network.di.NetworkModule
import dagger.Module

@Module(includes = [NetworkModule::class, StorageModule::class])
class DomainModule