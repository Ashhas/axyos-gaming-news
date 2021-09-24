package com.example.gamingnews.ui.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gamingnews.databinding.ActivityDetailsBinding
import com.example.gamingnews.databinding.ActivityMainBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val link = intent.getStringExtra("ARTICLE_LINK")

        if (link != null) {
            binding.wvArticle.loadUrl(link)
        }
    }
}