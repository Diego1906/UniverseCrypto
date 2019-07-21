package com.teste.universecrypto.presentation.Utils

import android.view.View

fun View.isVisible(isVisible : Boolean){
    this.visibility = if(isVisible) View.VISIBLE else View.GONE
}
