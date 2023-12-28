package com.example.mynotes.ui.components

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import java.util.Date

class CompassRotateView : androidx.appcompat.widget.AppCompatImageView{
    constructor(context: Context):super(context)
    constructor(context: Context, attributeSet: AttributeSet):super(context,attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int):super(context,attributeSet,defStyleAttr)

    val TIME_DELTA_THRESHOLD = 0.25f // maximum time difference between iterations, s
    val ANGLE_DELTA_THRESHOLD = 0.1f // minimum rotation change to be redrawn, deg
    val INERTIA_MOMENT_DEFAULT = 0.1f // default physical properties
    val ALPHA_DEFAULT = 10f
    val MB_DEFAULT = 1000f
    var time1: Long = 0
    var time2 :Long = 0 // timestamps of previous iterations--used in numerical integration
    var angle1 = 0f
    var angle2:Float = 0f
    var angle0:Float = 0f// angles of previous iterations
    var angleLastDrawn = 0f // last drawn anglular position
    var animationOn = false // if animation should be performed
    var inertiaMoment = INERTIA_MOMENT_DEFAULT // moment of inertia
    var alphaValue = ALPHA_DEFAULT // damping coefficient
    var mB = MB_DEFAULT // magnetic field coefficient

    override fun onDraw(canvas: Canvas?) {
        if (animationOn) {
            if (angleRecalculate(Date().getTime())) {
                this.rotation = angle1
            }
        } else {
            this.rotation = angle1
        }
        super.onDraw(canvas)
        if (animationOn) {
            this.invalidate()
        }
    }

    /**
     * Use this to set physical properties.
     * Negative values will be replaced by default values
     *
     * @param inertiaMoment Moment of inertia (default 0.1)
     * @param alpha             Damping coefficient (default 10)
     * @param mB                Magnetic field coefficient (default 1000)
     */
    fun setPhysical(inertiaMoment: Float, alpha: Float, mB: Float) {
        this.inertiaMoment = if (inertiaMoment >= 0) inertiaMoment else INERTIA_MOMENT_DEFAULT
        this.alphaValue = if (alpha >= 0) alpha else ALPHA_DEFAULT
        this.mB = if (mB >= 0) mB else MB_DEFAULT
    }


    /**
     * Use this to set new "magnetic field" angle at which image should rotate
     *
     * @param   angleNew    new magnetic field angle, deg., relative to vertical axis.
     * @param   animate     true, if image shoud rotate using animation, false to set new rotation instantly
     */
    fun rotationUpdate(angleNew: Float, animate: Boolean) {
        if (animate) {
            if (Math.abs(angle0 - angleNew) > ANGLE_DELTA_THRESHOLD) {
                angle0 = angleNew
                this.invalidate()
            }
            animationOn = true
        } else {
            angle1 = angleNew
            angle2 = angleNew
            angle0 = angleNew
            angleLastDrawn = angleNew
            this.invalidate()
            animationOn = false
        }
    }

    /**
     * Recalculate angles using equation of dipole circular motion
     *
     * @param   timeNew     timestamp of method invoke
     * @return              if there is a need to redraw rotation
     */
    protected fun angleRecalculate(timeNew: Long): Boolean {

        // recalculate angle using simple numerical integration of motion equation
        var deltaT1 = (timeNew - time1) / 1000f
        if (deltaT1 > TIME_DELTA_THRESHOLD) {
            deltaT1 = TIME_DELTA_THRESHOLD
            time1 = timeNew + Math.round(TIME_DELTA_THRESHOLD * 1000)
        }
        var deltaT2 = (time1 - time2) / 1000f
        if (deltaT2 > TIME_DELTA_THRESHOLD) {
            deltaT2 = TIME_DELTA_THRESHOLD
        }

        // circular acceleration coefficient
        val koefI = inertiaMoment / deltaT1 / deltaT2

        // circular velocity coefficient
        val koefAlpha = alphaValue / deltaT1

        // angular momentum coefficient
        val koefk =
            mB * (Math.sin(Math.toRadians(angle0.toDouble())) * Math.cos(Math.toRadians(angle1.toDouble())) -
                    Math.sin(Math.toRadians(angle1.toDouble())) * Math.cos(Math.toRadians(angle0.toDouble()))).toFloat()
        val angleNew =
            (koefI * (angle1 * 2f - angle2) + koefAlpha * angle1 + koefk) / (koefI + koefAlpha)

        // reassign previous iteration variables
        angle2 = angle1
        angle1 = angleNew
        time2 = time1
        time1 = timeNew

        // if angles changed less then threshold, return false - no need to redraw the view
        return if (Math.abs(angleLastDrawn - angle1) < ANGLE_DELTA_THRESHOLD) {
            false
        } else {
            angleLastDrawn = angle1
            true
        }
    }
}