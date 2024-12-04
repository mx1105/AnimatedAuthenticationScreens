package com.mnaik.animatedauthenticationscreens.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.mnaik.animatedauthenticationscreens.R


/**
 * Created by Monil Naik on 04-12-2024.
 */

class CustomProgress(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    var paint: Paint = Paint()
    var innerPaint: Paint = Paint()
    var midPaint: Paint = Paint()
    var animationProgress: Float = 0f
    var animationProgress2: Float = 0f
    var animationProgress3: Float = 0f
    private var inRad = 0f
    private var outRad = 0f
    private var colorArc = 0
    private var colorArc2 = 0
    private var midRad = 0f
    private var colorArc3 = 0

    private var outerAlpha = 0
    private var midAlpha = 0

    private var minRad = 0f

    var distance: Float = 0f
    var distance2: Float = 0f

    private var speed: Float = 0f

    var zoom: Boolean = false
    var zoom2: Boolean = false
    var zoom3: Boolean = false

    public override fun onDraw(canvas: Canvas) {
        canvas.drawCircle((width / 2).toFloat(), (height / 2).toFloat(), animationProgress, paint)
        canvas.drawCircle(
            (width / 2).toFloat(), (height / 2).toFloat(), animationProgress3, midPaint
        )
        canvas.drawCircle(
            (width / 2).toFloat(), (height / 2).toFloat(), animationProgress2, innerPaint
        )
    }

    var animator: Runnable = object : Runnable {
        override fun run() {
            if (zoom) {
                animationProgress -= speed
            }
            if (!zoom) {
                animationProgress += speed
            }
            if (animationProgress >= outRad) {
                zoom = true
            }
            if (animationProgress <= minRad + distance) {
                zoom = false
            }
            if (zoom3) {
                animationProgress3 -= speed
            }
            if (!zoom3) {
                animationProgress3 += speed
            }
            if (animationProgress3 >= midRad) {
                zoom3 = true
            }
            if (animationProgress3 <= minRad + distance2) {
                zoom3 = false
            }
            if (zoom2) {
                animationProgress2 -= speed
            }
            if (!zoom2) {
                animationProgress2 += speed
            }
            if (animationProgress2 >= inRad) {
                zoom2 = true
            }
            if (animationProgress2 <= minRad) {
                zoom2 = false
            }
            invalidate()
            postDelayed(this, 30)
        }
    }

    init {
        paint.style = Paint.Style.FILL
        paint.flags = Paint.ANTI_ALIAS_FLAG
        innerPaint.style = Paint.Style.FILL
        innerPaint.flags = Paint.ANTI_ALIAS_FLAG
        midPaint.style = Paint.Style.FILL
        midPaint.flags = Paint.ANTI_ALIAS_FLAG
        val array = context.theme.obtainStyledAttributes(attrs, R.styleable.CustomProgress, 0, 0)
        try {
            inRad = array.getDimension(R.styleable.CustomProgress_inner_radius, 50f)
            colorArc = array.getColor(
                R.styleable.CustomProgress_inner_color, Color.parseColor("#5C6BC0")
            )
            outRad = array.getDimension(R.styleable.CustomProgress_outer_radius, 90f)
            colorArc2 = array.getColor(
                R.styleable.CustomProgress_outer_color, Color.parseColor("#1A237E")
            )
            midRad = array.getDimension(R.styleable.CustomProgress_mid_radius, 70f)
            colorArc3 =
                array.getColor(R.styleable.CustomProgress_mid_color, Color.parseColor("#1A237E"))
            minRad = array.getDimension(R.styleable.CustomProgress_min_radius, 10f)
            speed = array.getFloat(R.styleable.CustomProgress_zoom_speed, 10f)
            midAlpha = array.getInteger(R.styleable.CustomProgress_mid_alpha, 50)
            outerAlpha = array.getInt(R.styleable.CustomProgress_outer_alpha, 100)
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        } finally {
            array.recycle()
        }
        paint.color = colorArc2
        innerPaint.color = colorArc
        midPaint.color = colorArc3

        paint.alpha = outerAlpha
        midPaint.alpha = midAlpha
        distance = outRad - inRad
        distance2 = midRad - inRad
        speed /= 10

        post(animator)
    }
}