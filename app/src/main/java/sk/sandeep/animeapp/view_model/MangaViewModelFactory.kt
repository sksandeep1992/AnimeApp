package sk.sandeep.animeapp.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import sk.sandeep.animeapp.repository.AnimeRepository

class MangaViewModelFactory(
    private val repository: AnimeRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MangaViewModel(repository) as T
    }
}