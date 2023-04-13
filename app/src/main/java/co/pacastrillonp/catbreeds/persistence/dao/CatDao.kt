package co.pacastrillonp.catbreeds.persistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import co.pacastrillonp.catbreeds.model.persistence.CatEntity
import io.reactivex.rxjava3.core.Flowable

@Dao
interface CatDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(catEntities: List<CatEntity>)

    @Query("SELECT * FROM ${CatEntity.TABLE_NAME} ORDER BY id DESC")
    fun getAllCats(): Flowable<List<CatEntity>>
}