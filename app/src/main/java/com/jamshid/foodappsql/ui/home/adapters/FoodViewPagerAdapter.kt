package com.jamshid.foodappsql.ui.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jamshid.foodappsql.R
import com.jamshid.foodappsql.databinding.AdVpItemBinding
import com.jamshid.foodappsql.ui.home.pager.FoodPager

class FoodViewPagerAdapter(fm:FragmentManager) : FragmentStatePagerAdapter(fm){
    override fun getCount(): Int {
        return 5
    }

    override fun getItem(position: Int): Fragment {
       return FoodPager()
    }


}