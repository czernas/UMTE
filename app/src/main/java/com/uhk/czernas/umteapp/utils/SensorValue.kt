package com.uhk.czernas.umteapp.utils

import android.hardware.Sensor

enum class SensorValue constructor(val sensorType: Int) {

    Accelerometer(Sensor.TYPE_ACCELEROMETER),
    Gyroscope(Sensor.TYPE_GYROSCOPE),
    Magnetometer(Sensor.TYPE_MAGNETIC_FIELD),
    OrientationVector(Sensor.TYPE_ROTATION_VECTOR); // gamma, x y z

    fun getType() : Int {
        return sensorType
    }
}