package com.example.finalsetup.repository

import android.content.Context
import com.example.finalsetup.apiInterface.ApiService
import com.example.finalsetup.model.LoginRequest
import dagger.hilt.android.qualifiers.ApplicationContext
import jakarta.inject.Inject

class AuthRepository @Inject constructor(
    var apiService: ApiService, @ApplicationContext context: Context
) : EmpBaseRepository() {
    suspend fun login(request: LoginRequest) = safeApiCall {
        apiService.login(request)
    }

}