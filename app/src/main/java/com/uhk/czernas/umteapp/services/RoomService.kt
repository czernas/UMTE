package com.uhk.czernas.umteapp.services

import android.app.IntentService
import android.content.Intent
import com.uhk.czernas.umteapp.ws.StagService
import com.uhk.czernas.umteapp.ws.stagService
import java.text.SimpleDateFormat
import java.util.*

class RoomService : IntentService {

    constructor() : super("RoomService")
    constructor(name: String?) : super(name)

    override fun onHandleIntent(intent: Intent?) {
        val rooms = mutableListOf("J8", "J9", "J10", "J23")
        val building = "J"

        val date = SimpleDateFormat("d.M.yyyy").format(Date())

        for (room in rooms) {
            val response = stagService.getTimetable(
                    building,
                    room,
                    date,
                    date,
                    StagService.JSON
            ).execute()

            response.body()?.items?.forEach { println(it.toString()) }
        }
    }
}