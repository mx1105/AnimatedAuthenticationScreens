package com.mnaik.animatedauthenticationscreens.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Monil Naik on 24-10-2024.
 */
@HiltViewModel
class ForgotPasswordViewModel @Inject constructor(/* define required class like Repository for API call */) :
    ViewModel() {
    var mUserName = MutableLiveData<String>()
    var mEnteredOtp = MutableLiveData<String>()
}