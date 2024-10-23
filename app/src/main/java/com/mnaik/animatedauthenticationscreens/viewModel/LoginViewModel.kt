package com.mnaik.animatedauthenticationscreens.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mnaik.animatedauthenticationscreens.model.LoginModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Monil Naik on 23-10-2024.
 */
@HiltViewModel
class LoginViewModel @Inject constructor(/* define required class like Repository for API call */) : ViewModel() {
    var mDataLoading = MutableLiveData<Boolean>()
    var mToastMessage = MutableLiveData<String>()
    var mOnLoginSuccess = MutableLiveData<Boolean>()
    var mForgotPasswordClick = MutableLiveData<Boolean>()
    var userLoginBody: LoginModel.RequestDate = LoginModel.RequestDate()

    fun userLogin() {
        //API call or code for verifying user
    }

    fun forgotPasswordClick() {
        mForgotPasswordClick.postValue(true)
    }

}