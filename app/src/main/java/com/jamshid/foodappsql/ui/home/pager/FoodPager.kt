package com.jamshid.foodappsql.ui.home.pager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jamshid.foodappsql.databinding.AdVpItemBinding

class FoodPager : Fragment() {
    private var _binding: AdVpItemBinding? = null
    val binding: AdVpItemBinding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = AdVpItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}