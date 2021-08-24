package com.example.gamingnews.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamingnews.data.RssFeed
import com.example.gamingnews.data.RssItem
import com.example.gamingnews.di.networkModule
import com.example.gamingnews.network.RssService
import com.example.gamingnews.repository.RssRepository
import com.example.gamingnews.repository.RssRepositoryImpl
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.*

class MainViewModel constructor(private val repository: RssRepositoryImpl) : ViewModel() {

    var sourceFeed: RssFeed? = null

    fun getAllGematsuArticles() {
        viewModelScope.launch {
            val result = repository.getGematsuArticles()
            Timber.d(result.toString())
            sourceFeed = result
        }
    }
}