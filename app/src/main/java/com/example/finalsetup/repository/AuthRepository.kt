package com.example.finalsetup.repository

import NewsPagingSource
import android.content.Context
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.finalsetup.apiInterface.ApiService
import com.example.finalsetup.model.LoginRequest
import com.example.finalsetup.model.NewsResponse
import com.example.finalsetup.model.ProductRequest
import dagger.hilt.android.qualifiers.ApplicationContext
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow

class AuthRepository @Inject constructor(
    var apiService: ApiService, @ApplicationContext context: Context
) : EmpBaseRepository() {
    suspend fun login(request: LoginRequest) = safeApiCall {
        apiService.login(request)
    }

    suspend fun comprehensive(token: String, productId: ProductRequest) = safeApiCall {
        apiService.comprehensive(token, productId)
    }
    fun getNews() = Pager(
        config = PagingConfig(
            pageSize = 20,
        ),
        pagingSourceFactory = {
            NewsPagingSource(apiService = apiService)
        }
    ).flow
}