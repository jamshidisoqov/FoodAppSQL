package com.jamshid.foodappsql.ui.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jamshid.foodappsql.R
import com.jamshid.foodappsql.databinding.FoodItemRcvBinding
import com.jamshid.foodappsql.domain.models.Food
import com.jamshid.foodappsql.domain.ui_state.FoodUiState

class FoodAdapter : RecyclerView.Adapter<FoodAdapter.Vh>() {

    private lateinit var binding: FoodItemRcvBinding
    private var foodList: List<Food> = emptyList()

    inner class Vh(var binding: FoodItemRcvBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(food: Food) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {

        binding = FoodItemRcvBinding.bind(
            LayoutInflater.from(parent.context).inflate(R.layout.food_item_rcv, parent, false)
        )

        return Vh(binding)
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {

    }

    override fun getItemCount(): Int = 20
    fun setData(list: FoodUiState) {
        this.foodList = list.data!!
        notifyDataSetChanged()
    }
}