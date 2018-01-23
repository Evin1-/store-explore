package com.example.myapplication.data.entities

import com.google.gson.annotations.SerializedName

data class Card(
    @SerializedName("title") var title: String? = null,
    @SerializedName("backgroundImage") var backgroundImage: String? = null,
    @SerializedName("content") var content: List<Content>? = null,
    @SerializedName("promoMessage") var promoMessage: String? = null,
    @SerializedName("topDescription") var topDescription: String? = null,
    @SerializedName("bottomDescription") var bottomDescription: String? = null
)
