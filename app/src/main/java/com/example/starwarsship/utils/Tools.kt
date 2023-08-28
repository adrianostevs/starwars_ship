package com.example.starwarsship.utils

import java.text.NumberFormat
import java.util.Locale

object Tools {

    fun getPriceFormat(amount: Double): String? {
        val localeUs = Locale("en", "US")
        val formatUsd: NumberFormat = NumberFormat.getCurrencyInstance(localeUs)
        formatUsd.maximumFractionDigits = 0
        return formatUsd.format(amount)
    }

}