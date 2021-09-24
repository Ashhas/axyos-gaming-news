package com.example.gamingnews.ui.main.ign

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamingnews.data.RssFeed
import com.example.gamingnews.repository.RssRepositoryImpl
import kotlinx.coroutines.launch
import timber.log.Timber

class IgnViewModel constructor(private val repository: RssRepositoryImpl) : ViewModel() {

    private val _sourceFeed = MutableLiveData<RssFeed>()
    val sourceFeed: LiveData<RssFeed> get() = _sourceFeed

    init {
        ignSelected()
    }

    private fun ignSelected() {
        viewModelScope.launch {
            _sourceFeed.value = getIgnArticles()
        }
    }

    private suspend fun getIgnArticles(): RssFeed {
        val result = repository.getIgnArticles()
        Timber.d(result.toString())
        return result
    }
}