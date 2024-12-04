package com.mnaik.animatedauthenticationscreens.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mnaik.animatedauthenticationscreens.R
import com.mnaik.animatedauthenticationscreens.databinding.FragmentSplashBinding
import com.mnaik.animatedauthenticationscreens.ui.AuthorizationActivity
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Monil Naik on 25-10-2024.
 */
@AndroidEntryPoint
class SplashFragment : Fragment(R.layout.fragment_splash) {
    private lateinit var mDataBinding: FragmentSplashBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        mDataBinding = FragmentSplashBinding.inflate(inflater, container, false)
        mDataBinding.lifecycleOwner = viewLifecycleOwner
        (requireActivity() as AuthorizationActivity).initialLoginAnimation()
        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
            (requireActivity() as AuthorizationActivity).collapseLayout()
        }, 2000)
        return mDataBinding.root
    }
}