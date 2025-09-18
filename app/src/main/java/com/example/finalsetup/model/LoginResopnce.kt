package com.example.finalsetup.model

import com.google.gson.annotations.SerializedName

data class LoginResopnce(
    @SerializedName("data")
    val `data`: Data?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("status")
    val status: Boolean?
) {
    data class Data(
        @SerializedName("accessToken")
        val accessToken: String?,
        @SerializedName("coordinates")
        val coordinates: Any?,
        @SerializedName("country_code")
        val countryCode: String?,
        @SerializedName("created_at")
        val createdAt: String?,
        @SerializedName("customer_id")
        val customerId: Any?,
        @SerializedName("date_of_birth")
        val dateOfBirth: Any?,
        @SerializedName("delete_status")
        val deleteStatus: String?,
        @SerializedName("device_token")
        val deviceToken: Any?,
        @SerializedName("device_type")
        val deviceType: String?,
        @SerializedName("email")
        val email: String?,
        @SerializedName("email_verified_at")
        val emailVerifiedAt: Any?,
        @SerializedName("fcm_token")
        val fcmToken: Any?,
        @SerializedName("first_name")
        val firstName: String?,
        @SerializedName("gender")
        val gender: Int?,
        @SerializedName("id")
        val id: Int?,
        @SerializedName("interest")
        val interest: List<String>,
        @SerializedName("is_block")
        val isBlock: Int?,
        @SerializedName("is_otp_verified")
        val isOtpVerified: String?,
        @SerializedName("is_seller")
        val isSeller: Int?,
        @SerializedName("is_seller_verified")
        val isSellerVerified: String?,
        @SerializedName("last_name")
        val lastName: String?,
        @SerializedName("mobile_number")
        val mobileNumber: String?,
        @SerializedName("occupation")
        val occupation: Any?,
        @SerializedName("online_staus")
        val onlineStaus: String?,
        @SerializedName("otp")
        val otp: Any?,
        @SerializedName("password1")
        val password1: String?,
        @SerializedName("profile_complete_status")
        val profileCompleteStatus: Int?,
        @SerializedName("rejected_reason")
        val rejectedReason: Any?,
        @SerializedName("rejected_type")
        val rejectedType: Any?,
        @SerializedName("seller_status")
        val sellerStatus: String?,
        @SerializedName("updated_at")
        val updatedAt: String?,
        @SerializedName("user_block_status")
        val userBlockStatus: String?,
        @SerializedName("user_status")
        val userStatus: String?,
        @SerializedName("user_verify")
        val userVerify: String?,
        @SerializedName("watchcollection")
        val watchcollection: String?,
        @SerializedName("watchenthusiast")
        val watchenthusiast: List<Int?>?
    )
}


