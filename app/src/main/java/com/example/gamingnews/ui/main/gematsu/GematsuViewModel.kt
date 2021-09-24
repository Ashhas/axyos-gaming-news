package com.example.gamingnews.ui.main.gematsu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamingnews.data.RssFeed
import com.example.gamingnews.repository.RssRepositoryImpl
import kotlinx.coroutines.launch
import timber.log.Timber

class GematsuViewModel constructor(private val repository: RssRepositoryImpl) : ViewModel() {

    private val _sourceFeed = MutableLiveData<RssFeed>()
    val sourceFeed: LiveData<RssFeed> get() = _sourceFeed

    init {
        gematsuSelected()
    }

    private fun gematsuSelected() {
        viewModelScope.launch {
            _sourceFeed.value = getAllGematsuArticles()
        }
    }

    private suspend fun getAllGematsuArticles(): RssFeed {
        val result = repository.getGematsuArticles()
        Timber.d(result.toString())
        return result
    }
}