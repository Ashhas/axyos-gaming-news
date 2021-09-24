package com.example.gamingnews.di

import com.example.gamingnews.ui.main.gematsu.GematsuViewModel
import com.example.gamingnews.ui.main.ign.IgnViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { GematsuViewModel(repository = get()) }
    viewModel { IgnViewModel(repository = get()) }

}