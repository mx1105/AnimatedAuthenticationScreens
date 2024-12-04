package com.mnaik.animatedauthenticationscreens.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mnaik.animatedauthenticationscreens.R
import com.mnaik.animatedauthenticationscreens.databinding.FragmentLoginBinding
import com.mnaik.animatedauthenticationscreens.ui.AuthorizationActivity
import com.mnaik.animatedauthenticationscreens.ui.home.HomeActivity
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
        mDataBinding.lifecycleOwner = this
        mDataBinding.viewModel = mViewModel
        return mDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeObserver()
    }

    private fun initializeObserver() {
        mViewModel.mForgotPasswordClick.observe(viewLifecycleOwner){
            if(it)findNavController().navigate(R.id.action_loginFragment_to_forgatPasswordFragment)
            mViewModel.mForgotPasswordClick.postValue(false)
        }

        mViewModel.mCloseFragment.observe(viewLifecycleOwner){
            findNavController().navigateUp()
        }

        mViewModel.mDataLoading.observe(viewLifecycleOwner) {

        }

        mViewModel.mOnLoginSuccess.observe(viewLifecycleOwner) {
            requireActivity().startActivity(Intent(requireActivity(),HomeActivity::class.java))
        }
    }
}