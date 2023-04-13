package co.pacastrillonp.catbreeds.model.persistence

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = CatEntity.TABLE_NAME)
data class CatEntity(
    @PrimaryKey val referenceImageId: String,
    val breadName: String,
    val origin: String,
    val affectionLevel: Int,
    val intelligence: Int,
    val imageUrl: String
) {
    companion object {
        const val TABLE_NAME = "cat_table"
    }
}