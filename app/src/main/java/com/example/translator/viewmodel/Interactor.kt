package com.example.translator.viewmodel


interface Interactor<T> {

    suspend fun getData(word: String, fromRemoteSource: Boolean): T
}
