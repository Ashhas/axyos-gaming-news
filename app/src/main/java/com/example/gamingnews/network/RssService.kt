package com.example.gamingnews.network

import com.example.gamingnews.data.RssFeed
import retrofit2.Call
import retrofit2.http.GET

interface RssService {

    @GET("Vp6GfTkvpjYKdylb.xml")
    suspend fun getGematsuFeed(): RssFeed

    @GET("liHjzvsEKSyxRLjo.xml")
    suspend fun getIgnFeed(): RssFeed
}