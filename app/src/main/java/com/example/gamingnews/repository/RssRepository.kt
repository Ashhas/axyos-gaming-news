package com.example.gamingnews.repository

import com.example.gamingnews.data.RssFeed

interface RssRepository {
    suspend fun getGematsuArticles() : RssFeed
    suspend fun getIgnArticles() : RssFeed

}