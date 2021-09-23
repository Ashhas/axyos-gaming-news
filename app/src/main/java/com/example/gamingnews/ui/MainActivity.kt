package com.example.gamingnews.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gamingnews.databinding.ActivityMainBinding
import com.example.gamingnews.ui.adapter.ArticleAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //ListView
        mainViewModel.sourceFeed.observe(this, Observer { newFeed ->
            //RecycleView Adapter
            binding.rvArticles.layoutManager = LinearLayoutManager(this)
            binding.rvArticles.adapter = ArticleAdapter(
                context = this,
                articles = newFeed.itemList
            )
        })

        //RadioButtons
        binding.radioGroupSourceSelection.setOnCheckedChangeListener { _, checkId ->
            if (checkId == binding.radioButtonGematsu.id) {
                mainViewModel.gematsuSelected()
            } else if (checkId == binding.radioButtonIgn.id) {
                mainViewModel.ignSelected()
            }
        }
    }
}