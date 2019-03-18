package com.example.view

import android.animation.ValueAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView

class ShakingImageView : ImageView {
    private val animator = ValueAnimator.ofFloat((-20).toFloat(), 15.toFloat()).apply {
        repeatMode = ValueAnimator.REVERSE
        repeatCount = ValueAnimator.INFINITE
        addUpdateListener { animation ->
            rotation = animation.animatedValue as Float
            rotationX = animation.animatedValue as Float
            rotationY = animation.animatedValue as Float
        }
    }

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context,
            attrs,
            defStyleAttr) {
        if (visibility == View.VISIBLE)
            animator.start()
        else
            animator.cancel()
    }

    override fun setVisibility(visibility: Int) {
        super.setVisibility(visibility)
        if (visibility == View.VISIBLE)
            animator.start()
        else
            animator.cancel()
    }

}