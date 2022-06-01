package com.example.jsonapp.di

import com.example.jsonapp.retrofit.RetrofitServiceInstance
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    val BASE_URL ="https://jsonplaceholder.typicode.com/"



    //singelton olarak içeride servis model vs. tanımlamasını yapacağımız 1 kere yapıp her yerde çağıracağımız dosya
    @Singleton
    @Provides
    fun getRetrofitServiceInstance(retrofit: Retrofit): RetrofitServiceInstance//Kullanılan servisin interfacesi
    {
        return retrofit.create(RetrofitServiceInstance::class.java)

    }
    @Singleton
    @Provides
    fun getRetrofitInstance() : Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }

}