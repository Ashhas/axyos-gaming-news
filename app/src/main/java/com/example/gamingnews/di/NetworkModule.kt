package com.example.gamingnews.di

import com.example.gamingnews.network.RssService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

val networkModule = module {

    single {
        Retrofit.Builder()
            .baseUrl("https://rss.app/feeds/")
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
    }

    single {
        get<Retrofit>().create(RssService::class.java)
    }
}