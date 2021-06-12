package com.example.myapplication2.home

import android.content.Context
import android.provider.Settings
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication2.db.AdData
import com.example.myapplication2.db.CheckUser
import com.example.myapplication2.db.RequestPost
import com.example.myapplication2.network.ApiClient
import com.example.myapplication2.network.ApiRepository
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {

    var android_id = ""
    lateinit var responseId: RequestPost

    private var _checkConnection = MutableLiveData<Int>()
    val checkConnection: LiveData<Int>
        get() = _checkConnection

    private var _checkConnection2 = MutableLiveData<Int>()
    val checkConnection2: LiveData<Int>
        get() = _checkConnection2

    private var _response = MutableLiveData<AdData>()
    val response: LiveData<AdData>
        get() = _response

    private var _response2 = MutableLiveData<CheckUser>()
    val response2: LiveData<CheckUser>
        get() = _response2


    init {
        callApiRequest()
//        callApiRequestCheckUser(responseId)
    }


    private fun callApiRequest() {
        val apiService = ApiClient.getApiService()
        val apiRepository = ApiRepository(apiService)
        val call: Call<AdData> = apiRepository.advertis()
        call.enqueue(object : Callback<AdData> {
            override fun onResponse(call: Call<AdData>, response: Response<AdData>) {
                this@HomeViewModel._response.value = response.body()
                _checkConnection.value = 100
            }

            override fun onFailure(call: Call<AdData>, t: Throwable) {
                _checkConnection.value = 200
            }
        })
    }

    fun callApiRequestCheckUser(android_id: RequestPost) {
        val apiService = ApiClient.getApiService()
        val apiRepository = ApiRepository(apiService)
        val call: Call<CheckUser> = apiRepository.sendCheckAndroidId(android_id)
        call.enqueue(object : Callback<CheckUser> {
            override fun onResponse(call: Call<CheckUser>, response: Response<CheckUser>) {

            }

            override fun onFailure(call: Call<CheckUser>, t: Throwable) {

            }
        })

    }

    fun getAndroidId(context: Context) {
        android_id =
            Settings.System.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
        responseId = RequestPost(android_id)

    }
}