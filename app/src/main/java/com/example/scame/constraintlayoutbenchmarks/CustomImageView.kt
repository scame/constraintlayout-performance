package com.example.scame.constraintlayoutbenchmarks

import android.content.Context
import android.support.v7.widget.AppCompatImageView
import android.util.AttributeSet
import android.util.Log
import android.widget.ImageView

class CustomImageView: AppCompatImageView {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val width = measuredWidth
        val height = Math.round(width * 0.5625f)

        setMeasuredDimension(width, height)
    }
}