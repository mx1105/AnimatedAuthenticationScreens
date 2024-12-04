package com.mnaik.animatedauthenticationscreens.ui.forgotPassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mnaik.animatedauthenticationscreens.R
import com.mnaik.animatedauthenticationscreens.databinding.FragmentForgotPasswordBinding
import com.mnaik.animatedauthenticationscreens.databinding.FragmentLoginBinding
import com.mnaik.animatedauthenticationscreens.viewModel.ForgotPasswordViewModel
import com.mnaik.animatedauthenticationscreens.viewModel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Monil Naik on 24-10-2024.
 */
@AndroidEntryPoint
class ForgotPasswordFragment : Fragment(R.layout.fragment_forgot_password) {
    private lateinit var mDataBinding: FragmentForgotPasswordBinding
    private val mViewModel: ForgotPasswordViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        mDataBinding = FragmentForgotPasswordBinding.inflate(inflater, container, false)
        mDataBinding.lifecycleOwner = viewLifecycleOwner
        mDataBinding.viewModel = mViewModel
        return mDataBinding.root
    }
}