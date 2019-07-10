package com.teste.universecrypto.presentation

import com.teste.universecrypto.domain.Article
import java.util.*

object DetailsContract {
    interface View {
        fun setDetailsData(item: Article)
        fun formateDate(date: String?) : String?
    }
}