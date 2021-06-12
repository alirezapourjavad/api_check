package com.example.myapplication2.network

import com.example.myapplication2.db.AdData
import com.example.myapplication2.db.CheckUser
import retrofit2.Call
import retrofit2.http.*


interface ApiService {
    @GET("app-api/splash/")
    fun getSplashAd(): Call<AdData>

    @POST("app-api/check-android-id/")
    fun checkAndroidId(
        @Body androidId: String
    ):Call<CheckUser>


}
