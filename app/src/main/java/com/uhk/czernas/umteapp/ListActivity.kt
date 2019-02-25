package com.uhk.czernas.umteapp

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, ListFragment())
                    .commitAllowingStateLoss()
        }
    }

}