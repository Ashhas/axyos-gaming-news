package com.example.gamingnews.ui

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gamingnews.data.RssFeed
import com.example.gamingnews.databinding.ActivityMainBinding
import com.example.gamingnews.ui.adapter.ArticleAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val articleItems = mainViewModel.getAllGematsuArticles()

        //RecycleView Adapter
        binding.rvArticles.adapter = ArticleAdapter(
            context = this,
            articles = mainViewModel.sourceFeed?.itemList
        )
        binding.rvArticles.layoutManager = LinearLayoutManager(this)

        //RadioButtons
        binding.radioGroupSourceSelection.setOnCheckedChangeListener { _, checkId ->
            if (checkId == binding.radioButtonGematsu.id) {
                mainViewModel.getAllGematsuArticles()
            }
        }
    }
}