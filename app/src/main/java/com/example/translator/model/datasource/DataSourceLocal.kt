package com.example.translator.model.datasource

import com.example.translator.model.AppState

interface DataSourceLocal<T> : DataSource<T> {

    suspend fun saveToDB(appState: AppState)
}
