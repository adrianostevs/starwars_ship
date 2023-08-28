package com.example.starwarsship.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.starwarsship.data.model.response.ListShip
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiService: ApiService) {

    fun getListShip(): Flow<PagingData<ListShip>> {
        return Pager(
            config = PagingConfig(10),
            pagingSourceFactory = { ShipPagingDataSource(apiService) }
        ).flow
    }
}