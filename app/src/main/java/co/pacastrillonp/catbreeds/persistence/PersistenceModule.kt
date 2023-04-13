package co.pacastrillonp.catbreeds.persistence

import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val persistenceModule = module {

    single {
        Room.databaseBuilder(
            androidContext(),
            CatBreedsDataBase::class.java,
            "CatBreedsDataBase"
        )
            .build()
    }

    single { get<CatBreedsDataBase>().CatDao() }
}