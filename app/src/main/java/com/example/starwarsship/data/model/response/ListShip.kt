package com.example.starwarsship.data.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ListShip(

    @Expose
    @SerializedName("name")
    val name: String? = null,

    @Expose
    @SerializedName("model")
    val model: String? = null,

    @Expose
    @SerializedName("manufacturer")
    val manufacturer: String? = null,

    @Expose
    @SerializedName("cost_in_credits")
    val costInCredits: String? = null,

    @Expose
    @SerializedName("cargo_capacity")
    val cargoCapacity: String? = null,

)
