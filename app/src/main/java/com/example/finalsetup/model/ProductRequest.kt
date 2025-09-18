package com.example.finalsetup.model

import com.google.gson.annotations.SerializedName

data class ProductRequest(
    @SerializedName("product_id")
    val productId: String?
)


