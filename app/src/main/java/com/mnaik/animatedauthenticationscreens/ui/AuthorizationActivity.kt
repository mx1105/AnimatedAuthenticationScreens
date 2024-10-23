package com.mnaik.animatedauthenticationscreens.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.mnaik.animatedauthenticationscreens.R
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Monil Naik on 23-10-2024.
 */
@AndroidEntryPoint
class AuthorizationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_authorization)
    }
}