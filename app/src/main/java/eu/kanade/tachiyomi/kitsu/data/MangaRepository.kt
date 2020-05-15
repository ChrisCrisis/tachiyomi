package eu.kanade.tachiyomi.kitsu.data

import android.content.Context
import eu.kanade.tachiyomi.kitsu.data.database.AppDatabase
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class MangaRepository private constructor(context: Context) : CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    private val dbService = AppDatabase.getInstance(context)

    fun searchFor(search: String) = dbService.mangaDao().searchFor(search)

    companion object {
        @Volatile
        private var INSTANCE: MangaRepository? = null

        fun getInstance(context: Context): MangaRepository =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: build(context).also { INSTANCE = it }
            }

        private fun build(context: Context) = MangaRepository(context)
    }
}
