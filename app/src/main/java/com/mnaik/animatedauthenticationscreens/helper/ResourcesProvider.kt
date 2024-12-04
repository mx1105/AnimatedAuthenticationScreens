package com.mnaik.animatedauthenticationscreens.helper

import com.mnaik.animatedauthenticationscreens.MyApplication
import com.mnaik.animatedauthenticationscreens.MyApplication.Companion.instance
import javax.inject.Inject

/**
 * Created by Monil Naik on 24-10-2024.
 */
class ResourcesProvider @Inject constructor() {
    fun getString(id: Int): String {
        return instance?.getString(id) ?: ""
    }
}