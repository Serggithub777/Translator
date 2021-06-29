package com.example.translator.presenter

import com.example.translator.model.AppState
import com.example.translator.view.View

interface Presenter<T : AppState, V : View> {

    fun attachView(view: V)

    fun detachView(view: V)

    fun getData(word: String, isOnline: Boolean)
}