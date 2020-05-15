package eu.kanade.tachiyomi.kitsu.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import eu.kanade.tachiyomi.kitsu.data.model.Manga

@Dao
interface MangaDao {

    @Query("SELECT * FROM manga WHERE title_short = :search")
    fun searchFor(search: String): LiveData<List<Manga>>

    @Query("SELECT * FROM manga WHERE mangaId = :id LIMIT 1")
    fun getMangaById(id: Long): LiveData<Manga>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertManga(mangaList: List<Manga>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertManga(manga: Manga)

    @Update
    suspend fun updateManga(manga: Manga)

    @Delete
    suspend fun deleteManga(manga: Manga)
}
