package com.example.starwarsship.data

import com.example.starwarsship.base.BaseResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("starships/")
    suspend fun getListShips(@Query("page") page: Int) : BaseResponse
}