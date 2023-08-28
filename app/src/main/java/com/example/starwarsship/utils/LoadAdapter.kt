package com.example.starwarsship.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.LoadState
import com.example.starwarsship.base.AppLoadingState
import com.example.starwarsship.base.AppRecyclerViewHolder
import com.example.starwarsship.databinding.AdapterLoadingBinding

class LoadAdapter : AppLoadingState<AdapterLoadingBinding, LoadAdapter.LoadStateViewHolder>() {
    override fun onViewBinding(parent: ViewGroup) =
        AdapterLoadingBinding.inflate(LayoutInflater.from(parent.context), parent, false)

    inner class LoadStateViewHolder(view: View) : AppRecyclerViewHolder<LoadState>(view) {
        override fun bindItem(item: LoadState, position: Int) {
            viewBinding.lottie.visibility =
                if (item is LoadState.Loading) View.VISIBLE else View.GONE
            viewBinding.mtvError.visibility =
                if (item is LoadState.Error) View.VISIBLE else View.GONE
        }
    }

    override fun onViewHolder(view: View) = LoadStateViewHolder(view)

}