package com.example.gamingnews.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    private val _sourceFeed = MutableLiveData<RssFeed>()
    val sourceFeed: LiveData<RssFeed> get() = _sourceFeed

    init {
        gematsuSelected()
    }

    fun gematsuSelected() {
        viewModelScope.launch {
            _sourceFeed.value = getAllGematsuArticles()
        }
    }

    fun ignSelected() {
        viewModelScope.launch {
            _sourceFeed.value = getIgnArticles()
        }
    }

    private suspend fun getAllGematsuArticles(): RssFeed {
        val result = repository.getGematsuArticles()
        Timber.d(result.toString())
        return result
    }

    private suspend fun getIgnArticles(): RssFeed {
        val result = repository.getIgnArticles()
        Timber.d(result.toString())
        return result
    }

}