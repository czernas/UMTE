package com.uhk.czernas.umteapp.model

import android.os.Build
import com.raizlabs.android.dbflow.annotation.Database

@Database(version = AppDatabase.VERSION,
        name=AppDatabase.NAME)
object AppDatabase {

    const val VERSION = 1
    const val NAME = "UmteAppDB"
}