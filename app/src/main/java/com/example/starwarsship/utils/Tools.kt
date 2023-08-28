package com.example.starwarsship.utils

import java.text.NumberFormat
import java.util.Locale

object Tools {

    fun getPriceFormat(amount: Double): String? {
        val localeID = Locale("in", "ID")
        val formatRupiah: NumberFormat = NumberFormat.getCurrencyInstance(localeID)
        formatRupiah.maximumFractionDigits = 0
        return formatRupiah.format(amount)
    }

}