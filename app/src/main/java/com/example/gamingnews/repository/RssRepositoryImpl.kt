package com.example.gamingnews.repository

import com.example.gamingnews.data.RssFeed
import com.example.gamingnews.network.RssService
import timber.log.Timber
import java.lang.Exception

class RssRepositoryImpl(private val api: RssService) : RssRepository {
    override suspend fun getGematsuArticles(): RssFeed {
        return api.getGematsuFeed()
    }

    override suspend fun getIgnArticles(): RssFeed {
        return api.getIgnFeed()
    }
}