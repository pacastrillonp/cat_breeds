package co.pacastrillonp.catbreeds.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import co.pacastrillonp.catbreeds.model.persistence.CatEntity
import co.pacastrillonp.catbreeds.persistence.dao.CatDao

@Database(
    version = CatBreedsDataBase.v01,
    entities = [CatEntity::class]
)

abstract class CatBreedsDataBase : RoomDatabase() {

    companion object {
        const val v01 = 1
    }

    abstract fun CatDao(): CatDao

}