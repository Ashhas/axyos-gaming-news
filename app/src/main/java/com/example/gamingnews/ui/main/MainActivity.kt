package com.example.gamingnews.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gamingnews.databinding.ActivityMainBinding
import com.example.gamingnews.ui.adapter.ArticleAdapter
import com.example.gamingnews.ui.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var TAB_NAMES = arrayOf<String>("Gematsu", "IGN")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Setup ViewPager Adapter
        binding.viewPager.adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        //Setup TabLayout
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = TAB_NAMES[position]
        }.attach()
    }
}