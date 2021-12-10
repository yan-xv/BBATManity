package com.rsschool.finaltask.yanxv.bbatmanity.network.di

import com.rsschool.finaltask.yanxv.bbatmanity.domain.repository.NetworkRepository
import com.rsschool.finaltask.yanxv.bbatmanity.network.BASE_URL
import com.rsschool.finaltask.yanxv.bbatmanity.network.api.BelarusbankApi
import com.rsschool.finaltask.yanxv.bbatmanity.network.repository.NetworkRepositoryImpl
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
class NetworkModule {

    @Provides
    fun networkRepositoryImpl(belarusbankApi: BelarusbankApi): NetworkRepository {
        return NetworkRepositoryImpl(belarusbankApi)
    }

    @Provides
    fun belarusbankApi(
        okHttpClient: OkHttpClient,
        moshiConverterFactory: MoshiConverterFactory
    ): BelarusbankApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(moshiConverterFactory)
            .build()
            .create(BelarusbankApi::class.java)
    }

    @Provides
    fun okHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Provides
    fun httpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    fun moshiConverterFactory(): MoshiConverterFactory {
        return MoshiConverterFactory.create()
    }
}
