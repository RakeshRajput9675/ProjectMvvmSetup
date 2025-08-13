package com.example.finalsetup.di


import android.content.Context
import com.example.finalsetup.helper.SharedPreference
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject


class SessionInterceptor @Inject constructor(
    @ApplicationContext private val context: Context
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)
        if (response.code == 401) {
            val sharedPreference = SharedPreference.get(context)
            sharedPreference.removePreferences()

        }

        return response
    }
}
