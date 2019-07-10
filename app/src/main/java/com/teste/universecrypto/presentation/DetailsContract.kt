package com.teste.universecrypto.presentation

import com.teste.universecrypto.domain.Article

object DetailsContract {
    interface View {
        fun setDetailsData(item: Article)
    }
}