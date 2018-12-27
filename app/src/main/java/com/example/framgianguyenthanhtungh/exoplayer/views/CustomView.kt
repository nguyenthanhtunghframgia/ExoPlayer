package com.example.framgianguyenthanhtungh.exoplayer.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.example.framgianguyenthanhtungh.exoplayer.R

class CustomView(
    context: Context,
    attributeSet: AttributeSet
) : View(context, attributeSet) {
    private var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var size: Int

    init {
        context.theme.obtainStyledAttributes(attributeSet, R.styleable.CustomView, 0, 0).apply {

            try {
                paint.color = getColor(R.styleable.CustomView_view_color, Color.RED)
                size = this.getDimensionPixelSize(R.styleable.CustomView_view_size, 200)
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

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.style = Paint.Style.STROKE
        canvas?.drawRect(
            (width / 2 - size / 2).toFloat(), (height / 2 - size / 2).toFloat(),
            (width / 2 + size / 2).toFloat(), (height / 2 + size / 2).toFloat(), paint
        )

        canvas?.drawCircle(100F, 100F, 50F, paint)
    }
}
