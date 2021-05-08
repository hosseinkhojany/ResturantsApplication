package com.example.resturantsapplication.ui.adapter

import android.os.SystemClock
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.resturantsapplication.R
import com.example.resturantsapplication.data.model.foodmodel.Food
import com.example.resturantsapplication.databinding.BigContentItemBinding
import com.skydoves.bindables.BindingListAdapter
import com.skydoves.bindables.binding

//horizontal adapter
class RestaurantAdapterH : BindingListAdapter<Food, RestaurantAdapterH.FoodViewHolder>(diffUtil) {

    private var onClickedAt = 0L

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val binding = parent.binding<BigContentItemBinding>(R.layout.big_content_item)
        return FoodViewHolder(binding).apply {
            binding.root.setOnClickListener {
                val position = bindingAdapterPosition.takeIf { it != RecyclerView.NO_POSITION }
                    ?: return@setOnClickListener

                //action to click list item

            }
        }
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.binding.apply {
            food = getItem(position)
            executePendingBindings()
        }
    }

    class FoodViewHolder(val binding: BigContentItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<Food>() {

            override fun areItemsTheSame(oldItem: Food, newItem: Food): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Food, newItem: Food): Boolean =
                oldItem == newItem
        }
    }
}
