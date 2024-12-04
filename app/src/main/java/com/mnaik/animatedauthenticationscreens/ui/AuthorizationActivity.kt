package com.mnaik.animatedauthenticationscreens.ui

import android.graphics.drawable.TransitionDrawable
import android.os.Bundle
import android.transition.TransitionManager
import android.view.ViewAnimationUtils
import android.view.ViewTreeObserver
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import com.mnaik.animatedauthenticationscreens.R
import com.mnaik.animatedauthenticationscreens.databinding.ActivityAuthorizationBinding
import com.mnaik.animatedauthenticationscreens.helper.zoomIn
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.hypot

/**
 * Created by Monil Naik on 23-10-2024.
 */
@AndroidEntryPoint
class AuthorizationActivity : AppCompatActivity() {
    private lateinit var mDataBinding: ActivityAuthorizationBinding
    private var isExpanded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_authorization)
        mDataBinding.lifecycleOwner = this
    }
    private fun toggleExpandCollapse(duration:Int = 400) {
        val constraintSet = ConstraintSet()
        constraintSet.clone(mDataBinding.clRoot) // root_layout is the parent layout containing cl_main
        mDataBinding.clMain.setBackgroundResource(R.drawable.transition_vector_background)
        val transitionDrawable = mDataBinding.clMain.background as TransitionDrawable
        if (isExpanded) {
            transitionDrawable.reverseTransition(duration) // Revert to the collapsed background
            constraintSet.connect(
                R.id.cl_main,
                ConstraintSet.BOTTOM,
                R.id.guideline_end_of_login_section,
                ConstraintSet.TOP,
                0
            )
        } else {
            transitionDrawable.startTransition(400) // Expand to the expanded background
            constraintSet.connect(
                R.id.cl_main, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 0
            )
        }
        TransitionManager.beginDelayedTransition(mDataBinding.clRoot)
        constraintSet.applyTo(mDataBinding.clRoot)
        isExpanded = !isExpanded
    }

    fun collapseLayout() {
        mDataBinding.dontLinear.isVisible = true
        if (isExpanded) toggleExpandCollapse()
    }

    fun expandLayout() {
        mDataBinding.dontLinear.isVisible = false
        toggleExpandCollapse()
    }

    fun initialLoginAnimation() {
        toggleExpandCollapse(0)
        mDataBinding.clMain.zoomIn()
    }
}