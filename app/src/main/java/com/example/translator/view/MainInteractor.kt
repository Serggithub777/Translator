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

class MainInteractor @Inject constructor(
    @Named(NAME_REMOTE) val repositoryRemote: Repository<List<DataModel>>,
    @Named(NAME_LOCAL) val repositoryLocal: Repository<List<DataModel>>
) : Interactor<AppState> {

    override fun getData(word: String, fromRemoteSource: Boolean): Observable<AppState> {
        return if (fromRemoteSource) {
            repositoryRemote
        } else {
            repositoryLocal
        }.getData(word).map { AppState.Success(it) }
    }
}