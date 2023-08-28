package com.example.starwarsship.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.starwarsship.data.MainRepository
import com.example.starwarsship.data.model.response.ListShip
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mMainRepository: MainRepository) : ViewModel() {

    fun getListShip(): LiveData<PagingData<ListShip>>{
        return mMainRepository.getListShip().cachedIn(viewModelScope).asLiveData()
    }
}