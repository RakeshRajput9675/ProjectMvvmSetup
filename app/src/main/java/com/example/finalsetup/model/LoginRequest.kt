package com.example.finalsetup.model

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("device_token")
    val deviceToken: String?,
    @SerializedName("device_type")
    val deviceType: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("password")
    val password: String?
)
