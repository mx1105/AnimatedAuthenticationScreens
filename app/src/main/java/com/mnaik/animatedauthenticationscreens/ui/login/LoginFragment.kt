package com.mnaik.animatedauthenticationscreens.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mnaik.animatedauthenticationscreens.R
import com.mnaik.animatedauthenticationscreens.databinding.FragmentLoginBinding
import com.mnaik.animatedauthenticationscreens.viewModel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Monil Naik on 23-10-2024.
 */
@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login) {
    private lateinit var mDataBinding: FragmentLoginBinding
    private val mViewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        mDataBinding = FragmentLoginBinding.inflate(inflater, container, false)
        mDataBinding.lifecycleOwner = viewLifecycleOwner
        mDataBinding.viewModel = mViewModel
        return mDataBinding.root
    }
}