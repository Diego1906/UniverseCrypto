package com.teste.universecrypto.presentation.Utils

import android.view.View

class Extensions {

    fun View.show() {
        this.visibility = View.VISIBLE
    }

    fun View.hide() {
        this.visibility = View.INVISIBLE
    }
}