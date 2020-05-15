package eu.kanade.tachiyomi.kitsu.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import eu.kanade.tachiyomi.kitsu.data.database.dao.MangaDao
import eu.kanade.tachiyomi.kitsu.data.model.Manga

@Database(
    entities = [Manga::class],
    version = AppDatabase.VERSION,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun mangaDao(): MangaDao

    companion object {
        private const val DB_NAME = "KitsuRock.db"
        const val VERSION = 1

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: build(context).also { INSTANCE = it }
            }

        private fun build(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME)
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}
