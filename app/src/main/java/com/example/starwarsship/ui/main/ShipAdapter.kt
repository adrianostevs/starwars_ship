package com.example.starwarsship.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.starwarsship.data.model.response.ListShip
import com.example.starwarsship.databinding.AdapterShipBinding
import com.example.starwarsship.utils.Tools

class ShipAdapter(diffUtil: DiffUtil.ItemCallback<ListShip>) :
    PagingDataAdapter<ListShip, ShipAdapter.ViewHolder>(diffUtil) {

    inner class ViewHolder(private val binding: AdapterShipBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun binding(data: ListShip) {
            binding.apply {
                mtvName.text = data.name
                mtvModel.text = data.model
                mtvManufacturer.text = data.manufacturer
                mtvCapacity.text = data.cargoCapacity
                mtvCost.text = try {
                    Tools.getPriceFormat(data.costInCredits?.toDouble() ?: 0.0)
                } catch (e: NumberFormatException) {
                    data.costInCredits
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            AdapterShipBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.binding(it) }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ListShip>() {
            override fun areItemsTheSame(
                oldItem: ListShip,
                newItem: ListShip
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: ListShip,
                newItem: ListShip
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

}