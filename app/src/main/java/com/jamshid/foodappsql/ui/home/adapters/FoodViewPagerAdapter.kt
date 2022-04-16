package com.jamshid.foodappsql.ui.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jamshid.foodappsql.R
import com.jamshid.foodappsql.databinding.AdVpItemBinding

class FoodViewPagerAdapter : RecyclerView.Adapter<FoodViewPagerAdapter.Vh>() {

    private lateinit var binding: AdVpItemBinding

    class Vh(binding: AdVpItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        binding = AdVpItemBinding.bind(
            LayoutInflater.from(parent.context).inflate(R.layout.ad_vp_item, parent, false)
        )
        return Vh(binding)
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {

    }

    override fun getItemCount(): Int = 3
}