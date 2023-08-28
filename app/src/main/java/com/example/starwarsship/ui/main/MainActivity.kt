package com.example.starwarsship.ui.main

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.starwarsship.base.BaseActivity
import com.example.starwarsship.databinding.ActivityMainBinding
import com.example.starwarsship.utils.LoadAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    private var mShipAdapter: ShipAdapter? = null

    private val mMainViewModel: MainViewModel by viewModels()

    override fun onViewBinding() = ActivityMainBinding.inflate(layoutInflater)

    override fun onCreated(savedInstanceState: Bundle?) {
        mShipAdapter = ShipAdapter(ShipAdapter.DIFF_CALLBACK)
        viewBinding.apply {
            rvList.adapter =
                mShipAdapter?.withLoadStateHeaderAndFooter(LoadAdapter(), LoadAdapter())
            mShipAdapter?.addLoadStateListener { loadState ->
                if (loadState.source.refresh is LoadState.Loading && mShipAdapter?.itemCount == 0) {
                    rvList.visibility = View.GONE
                    lottie.visibility = View.VISIBLE
                } else {
                    rvList.visibility = View.VISIBLE
                    lottie.visibility = View.GONE
                }
            }
            rvList.layoutManager = LinearLayoutManager(this@MainActivity)
        }

        mMainViewModel.getListShip().observe(this) {
            try {
                mShipAdapter?.submitData(lifecycle, it)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}