package com.uhk.czernas.umteapp.utils

import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import java.text.DecimalFormat

val decimalFormat by lazy {
    DecimalFormat()
}

fun Float.toOutFormat() : String {
    return decimalFormat.format(this)
}

fun <T> Spinner.onItemSelected(listener: (item: T) -> Unit) {
    this.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

        override fun onNothingSelected(p0: AdapterView<*>?) {

        }

        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            listener.invoke(selectedItem as T)
        }
    }
}