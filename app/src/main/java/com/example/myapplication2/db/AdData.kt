package com.example.myapplication2.db


import com.google.gson.annotations.SerializedName

data class AdData(
    @SerializedName("link")
    val link: String?,
    @SerializedName("photo")
    val photo: String?
)