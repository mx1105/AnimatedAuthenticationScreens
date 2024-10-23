package com.mnaik.animatedauthenticationscreens.model

/**
 * Created by Monil Naik on 23-10-2024.
 */
class LoginModel {

    /**
     * User login  Request body
     *
     * @property userName
     * @property password
     * @constructor Create empty User login body
     */
    data class RequestDate(
        var userName: String = "", var password: String = ""
    )
}