package com.example.mynotes.ui

import android.content.Context
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.mynotes.databinding.FragmentCompassBinding
import com.example.mynotes.viewmodels.CompassViewModel


/**
 * A simple [Fragment] subclass.
 * create an instance of this fragment.
 */
class CompassFragment : Fragment(), SensorEventListener {

    private lateinit var currentSensorManager: SensorManager
    var currentDegree:Float = 0f
    private val accelerometerReading = FloatArray(3)
    private val magnetometerReading = FloatArray(3)
    private var floatOrientation = FloatArray(3)
    private var floatRotationMatrix = FloatArray(9)

    private var _binding: FragmentCompassBinding? = null
    private val binding get() = _binding!!

    private val compassViewModel by activityViewModels<CompassViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCompassBinding.inflate(inflater, container, false)
        currentSensorManager = activity?.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        registerListeners()
    }

    override fun onPause() {
        super.onPause()
        currentSensorManager?.unregisterListener(this);
    }

    fun registerListeners(){
        currentSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)?.also { accelerometer ->
            currentSensorManager.registerListener(this,accelerometer, SensorManager.SENSOR_DELAY_NORMAL,SensorManager.SENSOR_DELAY_UI)
        }
        currentSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD).also { magneticfield ->
            currentSensorManager.registerListener(this,magneticfield, SensorManager.SENSOR_DELAY_NORMAL, SensorManager.SENSOR_DELAY_UI)
        }
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if(event?.sensor?.type == Sensor.TYPE_ACCELEROMETER){
            System.arraycopy(event.values,0,accelerometerReading,0,accelerometerReading.size)
        }
        else if(event?.sensor?.type == Sensor.TYPE_MAGNETIC_FIELD){
            System.arraycopy(event.values,0,magnetometerReading, 0, magnetometerReading.size)
            calculateMagneticField()
        }
        updateOrientationAngles()
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }

    fun calculateMagneticField(){
        var mag = magnetometerReading
        var magneticValue = Math.sqrt((mag[0] * mag[0] + mag[1] * mag[1] + mag[2] * mag[2]).toDouble())

        var label = "STRENGTH"
        var magneticText = SpannableString("$label ${magneticValue.toInt()}")
        magneticText.setSpan(ForegroundColorSpan(Color.WHITE), label.length, magneticText.length, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        binding.magneticTextView.text = magneticText
    }

    fun updateOrientationAngles(){
        SensorManager.getRotationMatrix(floatRotationMatrix, null, accelerometerReading, magnetometerReading);
        SensorManager.getOrientation(floatRotationMatrix, floatOrientation);

        val degrees = (Math.toDegrees(floatOrientation.get(0).toDouble()) + 360.0) % 360.0;
        binding.compassImage.rotationUpdate(-degrees.toFloat(),true);
        //Textview setting
        var direction = getDirection(degrees);
        var angleInt = degrees.toInt()
        binding.angleTextView.text = "$angleInt $direction"
    }

    fun getDirection(angle: Double): String{
        if(angle >= 350 || angle <= 10){
            return "NORTH"
        }else if(angle < 350 && angle > 280){
            return "NORTH-WEST"
        }else if(angle <= 280 && angle > 260){
            return "WEST";
        }else if(angle <= 260 && angle >190){
            return "SOUTH-WEST"
        }else if(angle <= 190 && angle > 170){
            return "SOUTH";
        }else if(angle <= 170 && angle > 100){
            return "SOUTH-EAST"
        }else if(angle <= 100 && angle > 80){
            return "EAST"
        }else if(angle <= 80 && angle > 10){
            return "NORTH_EAST"
        }
        return ""
    }
}