package com.example.gamingnews.ui.main.gematsu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gamingnews.databinding.FragmentGematsuBinding
import com.example.gamingnews.ui.adapter.ArticleAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class GematsuFragment : Fragment() {
    private lateinit var binding: FragmentGematsuBinding
    private val gematsuViewModel by viewModel<GematsuViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Setup Fragment ViewBinding
        binding = FragmentGematsuBinding.inflate(inflater, container, false)

        //RecycleView
        gematsuViewModel.sourceFeed.observe(viewLifecycleOwner, Observer { newFeed ->
            binding.rvGematsuArticles.layoutManager = LinearLayoutManager(context)
            binding.rvGematsuArticles.adapter = ArticleAdapter(
                context = context,
                articles = newFeed.itemList
            )
        })

        return binding.root
    }
}