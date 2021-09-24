package com.example.gamingnews.ui.main.ign

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gamingnews.databinding.FragmentIgnBinding
import com.example.gamingnews.ui.adapter.ArticleAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class IgnFragment : Fragment() {

    private lateinit var binding: FragmentIgnBinding
    private val ignViewModel by viewModel<IgnViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //Setup Fragment ViewBinding
        binding = FragmentIgnBinding.inflate(inflater, container, false)

        //RecycleView
        ignViewModel.sourceFeed.observe(viewLifecycleOwner, Observer { newFeed ->
            binding.rvIgnArticles.layoutManager = LinearLayoutManager(context)
            binding.rvIgnArticles.adapter = ArticleAdapter(
                context = context,
                articles = newFeed.itemList
            )
        })
        return binding.root
    }
}