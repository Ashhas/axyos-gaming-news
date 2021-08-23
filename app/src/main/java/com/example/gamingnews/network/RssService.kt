package com.example.gamingnews.network

import com.example.gamingnews.data.RssFeed
import retrofit2.Call
import retrofit2.http.GET

interface RssService {

    @GET("HP7b1uFM8k1ROWKM.xml")
    suspend fun getGematsuFeed(): RssFeed
}