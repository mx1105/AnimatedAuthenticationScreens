package com.mnaik.animatedauthenticationscreens.helper

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import androidx.constraintlayout.widget.ConstraintLayout


/**
 * Created by Monil Naik on 25-10-2024.
 */
fun ConstraintLayout.zoomIn(duration: Long = 400): AnimatorSet {
    val scaleX = ObjectAnimator.ofFloat(this, "scaleX", 0f, 1f)
    val scaleY = ObjectAnimator.ofFloat(this, "scaleY", 0f, 1f)

    scaleX.setDuration(duration)
    scaleY.setDuration(duration)

    scaleX.start()
    scaleY.start()

    val animatorSet = AnimatorSet()
    animatorSet.play(scaleX).with(scaleY)
    animatorSet.start()
    return animatorSet
}
