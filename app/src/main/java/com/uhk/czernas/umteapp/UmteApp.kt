package com.uhk.czernas.umteapp

import android.app.Application
import com.raizlabs.android.dbflow.config.FlowManager
import com.uhk.czernas.umteapp.prefs.Prefs

class UmteApp : Application() {

    override fun onCreate() {
        super.onCreate()

        Prefs.init(applicationContext)

        FlowManager.init(this)
    }
}