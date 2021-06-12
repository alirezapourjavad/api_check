package com.example.myapplication2.db


import com.google.gson.annotations.SerializedName

data class CheckUser(
    @SerializedName("user_exist")
    val userExist: Boolean?
)