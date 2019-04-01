package com.uhk.czernas.umteapp.sensors

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import com.uhk.czernas.umteapp.R
import com.uhk.czernas.umteapp.utils.SensorValue
import com.uhk.czernas.umteapp.utils.onItemSelected
import com.uhk.czernas.umteapp.utils.toOutFormat
import kotlinx.android.synthetic.main.activity_sensor.*
import java.math.RoundingMode
import java.text.DecimalFormat

class SensorActivity : AppCompatActivity(), SensorEventListener {

    var sensorType = SensorValue.Accelerometer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensor)

        val manager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        for (value in SensorValue.values()) {
            manager.registerListener(this,
                    manager.getDefaultSensor(value.getType()),
                    SensorManager.SENSOR_DELAY_FASTEST)
        }

        val sensorAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, android.R.id.text1, SensorValue.values())
        spinner.adapter = sensorAdapter

        spinner.onItemSelected<SensorValue> {
            sensorType = it
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    override fun onSensorChanged(event: SensorEvent?) {
        event?.let {
            if (it.sensor.type == sensorType.getType()) {
                xTextView.text = it.values[0].toOutFormat() //X
                yTextView.text = it.values[1].toOutFormat() //Y
                zTextView.text = it.values[2].toOutFormat() //Z
            }
        }
    }
}