package com.example.translator.di
import androidx.room.Room
import com.example.model.data.DataModel
import com.example.repository.RetrofitImplementation
import com.example.repository.RoomDataBaseImplementation
import com.example.repository.Repository
import com.example.repository.RepositoryImplementation
import com.example.repository.RepositoryImplementationLocal
import com.example.repository.RepositoryLocal
import com.example.repository.room.HistoryDataBase
import com.example.translator.view.main.MainInteractor
import com.example.translator.view.main.MainViewModel
import com.example.hystoryscreen.history.HistoryInteractor
import com.example.hystoryscreen.history.HistoryViewModel
import org.koin.dsl.module

val application = module {
    single { Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDB").build() }
    single { get<HistoryDataBase>().historyDao() }
    single<Repository<List<DataModel>>> { RepositoryImplementation(RetrofitImplementation()) }
    single<RepositoryLocal<List<DataModel>>> { RepositoryImplementationLocal(
        RoomDataBaseImplementation(get())
    )
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
