package com.example.translator.view

import com.example.translator.model.AppState

interface View {
    fun renderData(appState: AppState)
}