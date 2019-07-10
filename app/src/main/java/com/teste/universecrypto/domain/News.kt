package com.teste.universecrypto.domain

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class News(

    @SerializedName("status")
    @Expose
    var status: String? = null,

    @SerializedName("totalResults")
    @Expose
    var totalResults: Int? = null,

    @SerializedName("articles")
    @Expose
    var articles: List<Article>? = null
) : Serializable
