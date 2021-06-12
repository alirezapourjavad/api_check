package com.example.myapplication2.network

import com.example.myapplication2.db.AdData
import com.example.myapplication2.db.CheckUser
import com.example.myapplication2.db.RequestPost
import com.google.gson.Gson
import retrofit2.Call

class ApiRepository(val apiService: ApiService) {
    fun advertis(): Call<AdData> {
        return apiService.getSplashAd()
    }

    fun sendCheckAndroidId(androidId: RequestPost):Call<CheckUser>{
        return apiService.checkAndroidId(Gson().toJson(androidId))
    }

}