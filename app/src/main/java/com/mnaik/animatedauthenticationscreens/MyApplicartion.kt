package com.mnaik.animatedauthenticationscreens

import android.app.Application
import com.mnaik.animatedauthenticationscreens.helper.ResourcesProvider
import dagger.hilt.android.HiltAndroidApp

/**
 * Created by Monil Naik on 23-10-2024.
 */
@HiltAndroidApp
class MyApplication : Application() {
    //TO-DO Language and Application Theme handling
    companion object {
        var instance: MyApplication? = null
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}