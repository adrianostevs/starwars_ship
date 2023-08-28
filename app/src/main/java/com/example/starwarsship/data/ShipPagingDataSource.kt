package com.example.starwarsship.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.starwarsship.data.model.response.ListShip
import javax.inject.Inject

class ShipPagingDataSource @Inject constructor(private val apiService: ApiService) :
    PagingSource<Int, ListShip>() {

    private companion object {
        const val INITIAL_PAGE_INDEX = 1
    }

    override fun getRefreshKey(state: PagingState<Int, ListShip>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ListShip> {
        return try {
            val page = params.key ?: INITIAL_PAGE_INDEX
            val responseData = apiService.getListShips(page)
            val data = ArrayList<ListShip>()
            responseData.results?.map {
                data.add(
                    ListShip(
                        name = it.name,
                        model = it.model,
                        manufacturer = it.manufacturer,
                        costInCredits = it.costInCredits,
                        cargoCapacity = it.cargoCapacity
                    )
                )
            }

            LoadResult.Page(
                data = data,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (data.isEmpty()) null else page + 1
            )

        } catch (exception: Exception) {
            return LoadResult.Error(exception)
        }
    }
}