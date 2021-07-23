package com.example.repository

import com.example.model.data.AppState
import com.example.model.data.DataModel
import com.example.translator.room.HistoryDao
import com.example.translator.utils.convertDataModelSuccessToEntity
import com.example.translator.utils.mapHistoryEntityToSearchResult


class RoomDataBaseImplementation(private val historyDao: HistoryDao) :
    DataSourceLocal<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return mapHistoryEntityToSearchResult(historyDao.all())
    }

    override suspend fun saveToDB(appState: AppState) {
        convertDataModelSuccessToEntity(appState)?.let {
            historyDao.insert(it)
        }
    }
}
