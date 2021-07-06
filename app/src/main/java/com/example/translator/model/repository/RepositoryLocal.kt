package com.example.translator.model.repository

import com.example.translator.model.AppState

interface RepositoryLocal<T> : Repository<T> {

    suspend fun saveToDB(appState: AppState)
}
