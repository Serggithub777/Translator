package com.example.repository

import com.example.model.data.AppState

interface DataSourceLocal<T> : DataSource<T> {

    suspend fun saveToDB(appState: AppState)
}
