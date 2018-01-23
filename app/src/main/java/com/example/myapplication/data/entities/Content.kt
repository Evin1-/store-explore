package com.example.myapplication.data.entities

import com.google.gson.annotations.SerializedName

data class Content(
    @SerializedName("target") var target: String? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("elementType") var elementType: String? = null
)