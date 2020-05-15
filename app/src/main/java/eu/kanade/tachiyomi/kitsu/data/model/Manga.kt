package eu.kanade.tachiyomi.kitsu.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "manga")
class Manga {
    @PrimaryKey
    @ColumnInfo(name = "mangaId")
    var mangaId: Long = 0
    @ColumnInfo(name = "title_short")
    var title: String? = null
}
