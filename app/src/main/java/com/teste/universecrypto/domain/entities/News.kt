package com.teste.universecrypto.domain.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.teste.universecrypto.domain.entities.Article
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
