package com.example.finalsetup.apiInterface

import com.example.finalsetup.model.LoginRequest
import com.example.finalsetup.model.LoginResopnce
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("api/login")
    suspend fun login(
        @Body login: LoginRequest,
    ): LoginResopnce


}
