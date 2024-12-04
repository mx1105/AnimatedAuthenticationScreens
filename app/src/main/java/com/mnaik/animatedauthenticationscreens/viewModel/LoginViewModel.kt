package com.mnaik.animatedauthenticationscreens.viewModel

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mnaik.animatedauthenticationscreens.R
import com.mnaik.animatedauthenticationscreens.helper.ResourcesProvider
import com.mnaik.animatedauthenticationscreens.model.LoginModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Delay
import javax.inject.Inject

/**
 * Created by Monil Naik on 23-10-2024.
 */
@HiltViewModel
class LoginViewModel @Inject constructor(private val resourcesProvider: ResourcesProvider/* define required class like Repository for API call */) : ViewModel() {
    var mDataLoading = MutableLiveData<Boolean>()
    var mToastMessage = MutableLiveData<String>()
    var mOnLoginSuccess = MutableLiveData<Boolean>()
    var mForgotPasswordClick = MutableLiveData<Boolean>()
    var mCloseFragment = MutableLiveData<Boolean>()
    var userLoginBody: LoginModel.RequestDate = LoginModel.RequestDate()

    fun userLogin() {
        //API call or code for verifying user

//        Below code added for fake api call
        mDataLoading.postValue(true)
        Handler(Looper.getMainLooper()).postDelayed({
            mDataLoading.postValue(false)
            mToastMessage.postValue(resourcesProvider.getString(R.string.login_successfully))
            mOnLoginSuccess.postValue(true)
        },5000)
    }

    fun forgotPasswordClick() {
        mForgotPasswordClick.postValue(true)
    }

}