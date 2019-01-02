package com.example.framgianguyenthanhtungh.exoplayer.views

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.example.framgianguyenthanhtungh.exoplayer.R

class CustomView(
    context: Context,
    attributeSet: AttributeSet
) : View(context, attributeSet) {
    private var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var size: Int
    private var circleX: Float = 100F
    private var circleY: Float = 100F
    private var circleRadius: Float = 50F
    private var bitmap: Bitmap? = null
    private var drawable: Int = 0

    init {
        context.theme.obtainStyledAttributes(attributeSet, R.styleable.CustomView, 0, 0).apply {

            try {
                // bitmap = BitmapFactory.decodeResource(resources, R.drawable.halo)
                paint.color = getColor(R.styleable.CustomView_view_color, Color.RED)
                size = this.getDimensionPixelSize(R.styleable.CustomView_view_size, 200)
                drawable = getResourceId(R.styleable.CustomView_view_drawable, 0)
                if (drawable != 0) {
                    bitmap = BitmapFactory.decodeResource(resources, drawable)
                }
            } finally {
                recycle()
            }
        }
    }

    fun swapColor() {
        paint.color = if (paint.color == Color.RED) {
            Color.GREEN
        } else {
            Color.RED
        }
        invalidate()
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                circleRadius++
                invalidate()
            }
            MotionEvent.ACTION_MOVE -> {
                val x = event.x
                val y = event.y
                val dx = Math.pow((x - circleX).toDouble(), 2.toDouble())
                val dy = Math.pow((y - circleY).toDouble(), 2.toDouble())
                if (dx + dy < Math.pow(50.toDouble(), 2.toDouble())) {
                    circleY = y
                    circleX = x
                    invalidate()
                }
            }

        }
        return super.onTouchEvent(event)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.style = Paint.Style.STROKE
        canvas?.drawRect(
            (width / 2 - size / 2).toFloat(), (height / 2 - size / 2).toFloat(),
            (width / 2 + size / 2).toFloat(), (height / 2 + size / 2).toFloat(), paint
        )

        canvas?.drawCircle(circleX, circleY, circleRadius, paint)
        canvas?.drawBitmap(bitmap ?: return, 0F, 0F, null)
    }

    private fun getResizedBitmap(newWidth: Int, newHeight: Int): Bitmap {
        val matrix = Matrix()
        val source = RectF(0F, 0F, bitmap!!.width.toFloat(), bitmap!!.height.toFloat())
        val dest = RectF(0F, 0F, newWidth.toFloat(), newHeight.toFloat())
        matrix.setRectToRect(source, dest, Matrix.ScaleToFit.CENTER)
        return Bitmap.createBitmap(bitmap!!, 0, 0, bitmap!!.width, bitmap!!.height, matrix, true)
    }
}
