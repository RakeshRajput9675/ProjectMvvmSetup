package com.example.finalsetup.apiInterface

import com.example.finalsetup.model.ComprehensiveResopnce
import com.example.finalsetup.model.LoginRequest
import com.example.finalsetup.model.LoginResopnce
import com.example.finalsetup.model.NewsResponse
import com.example.finalsetup.model.ProductRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

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

//    https://newsapi.org/v2/everything?q=apple&sortBy=popularity&apiKey=APIKEY&pageSize=20&page=1
    @GET("everything?q=apple&sortBy=popularity&apiKey=${"dc60e3b46d9b4919bd54cd86bc5af82b"}&pageSize=20")
    suspend fun fetchNewApi(
        @Query("page") page: Int
        ): NewsResponse


//    interface NewsApiService {
//        @GET("everything?q=apple&sortBy=popularity&apiKey=${Constants.API_KEY}&pageSize=20")
//        suspend fun getNews(
//            @Query("page") page: Int
//        ): NewsResponse
//    }

}
