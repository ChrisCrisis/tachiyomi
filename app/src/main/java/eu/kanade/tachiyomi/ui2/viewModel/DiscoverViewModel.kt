package eu.kanade.tachiyomi.ui2.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import eu.kanade.tachiyomi.kitsu.data.MangaRepository

class DiscoverViewModel(application: Application) : AndroidViewModel(application) {

    private val mangaRepository = MangaRepository.getInstance(application.applicationContext)

    fun searchFor(search: String) = mangaRepository.searchFor(search)
}
