package com.example.starwarsship.base

import com.example.starwarsship.data.model.response.ListShip
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BaseResponse(

    @Expose
    @SerializedName("results")
    val results: List<ListShip>? = null,

)
