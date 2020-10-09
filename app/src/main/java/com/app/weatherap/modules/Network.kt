package com.app.weatherap.modules

import com.app.weatherap.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class Network {
    @Provides
    @Singleton
    fun provideRetrofit(
        baseUrl: String,
        okHttpClient: OkHttpClient,
        converterFactory: GsonConverterFactory
    ): CharacterService {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(converterFactory)
            .client(okHttpClient)
            .build().create(CharacterService::class.java)//Doesn't require the adapter
    }

    @Provides
    @Singleton
    fun provideBaseUrl(): String {
        return "http://api.openweathermap.org/data/2.5/"
    }

    @Provides
    @Singleton
    fun provideConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return if (BuildConfig.DEBUG) { // debug ON
            OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .readTimeout(100, TimeUnit.SECONDS)
                .connectTimeout(100, TimeUnit.SECONDS)
                .build()
        } else // debug OFF
            OkHttpClient.Builder()
                .readTimeout(100, TimeUnit.SECONDS)
                .connectTimeout(100, TimeUnit.SECONDS)
                .build()
    }

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }
}