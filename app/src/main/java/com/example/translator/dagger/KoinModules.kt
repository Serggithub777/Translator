package com.example.translator.dagger
import androidx.room.Room
import com.example.model.data.DataModel
import com.example.translator.model.datasource.RetrofitImplementation
import com.example.translator.model.datasource.RoomDataBaseImplementation
import com.example.translator.model.repository.Repository
import com.example.translator.model.repository.RepositoryImplementation
import com.example.translator.model.repository.RepositoryImplementationLocal
import com.example.translator.model.repository.RepositoryLocal
import com.example.translator.room.HistoryDataBase
import com.example.translator.view.MainInteractor
import com.example.translator.view.MainViewModel
import com.example.translator.view.history.HistoryInteractor
import com.example.translator.view.history.HistoryViewModel
import org.koin.dsl.module

val application = module {
    single { Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDB").build() }
    single { get<HistoryDataBase>().historyDao() }
    single<Repository<List<DataModel>>> { RepositoryImplementation(RetrofitImplementation()) }
    single<RepositoryLocal<List<DataModel>>> { RepositoryImplementationLocal(RoomDataBaseImplementation(get()))
    }
}

val mainScreen = module {
    factory { MainViewModel(get()) }
    factory { MainInteractor(get(), get()) }
}

val historyScreen = module {
    factory { HistoryViewModel(get()) }
    factory { HistoryInteractor(get(), get()) }
}
