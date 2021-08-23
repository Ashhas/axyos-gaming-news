package com.example.gamingnews.di

import com.example.gamingnews.repository.RssRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single { RssRepositoryImpl(get()) }
}