package com.jamshid.foodappsql.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.jamshid.foodappsql.databinding.HomeFragmentBinding
import com.jamshid.foodappsql.ui.home.adapters.FoodAdapter
import com.jamshid.foodappsql.ui.home.adapters.FoodViewPagerAdapter
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {


    private val viewModel: HomeViewModel by viewModel()
    private var _binding: HomeFragmentBinding? = null
    private val binding: HomeFragmentBinding get() = _binding!!
    private lateinit var adapter:FoodAdapter
    private lateinit var vpAdapter: FoodViewPagerAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = HomeFragmentBinding.inflate(inflater, container, false)

        adapter = FoodAdapter()
        vpAdapter= FoodViewPagerAdapter()

        binding.introViewPager.adapter=adapter
        binding.dotsIndicator.setViewPager2(binding.introViewPager)

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.state.collectLatest {
                adapter.setData(it)
            }
        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}