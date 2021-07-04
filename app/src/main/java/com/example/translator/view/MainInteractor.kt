package com.example.translator.view

import com.example.translator.dagger.NAME_LOCAL
import com.example.translator.dagger.NAME_REMOTE
import com.example.translator.model.AppState
import com.example.translator.model.data.DataModel
import com.example.translator.model.repository.Repository
import com.example.translator.viewmodel.Interactor
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Named

class MainInteractor(
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: Repository<List<DataModel>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(
            if (fromRemoteSource) {
                repositoryRemote
            } else {
                repositoryLocal
            }.getData(word)
        )
    }
}
