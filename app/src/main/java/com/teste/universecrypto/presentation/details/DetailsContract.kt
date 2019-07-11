package com.teste.universecrypto.presentation.details

import com.teste.universecrypto.domain.Article

object DetailsContract {
    interface View {
        fun setDetailsData(item: Article)
        fun formateDate(date: String?): String?
    }
}