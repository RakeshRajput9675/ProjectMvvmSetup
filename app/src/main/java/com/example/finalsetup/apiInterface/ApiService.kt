package com.example.finalsetup.apiInterface

import com.example.finalsetup.model.ComprehensiveResopnce
import com.example.finalsetup.model.LoginRequest
import com.example.finalsetup.model.LoginResopnce
import com.example.finalsetup.model.ProductRequest
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {

    @POST("api/login")
    suspend fun login(
        @Body login: LoginRequest,
    ): LoginResopnce

    @POST("api/user/get_single_product_details")
    suspend fun comprehensive(
        @Header("Authorization") token: String,
        @Body productId: ProductRequest,

        ): ComprehensiveResopnce


}
