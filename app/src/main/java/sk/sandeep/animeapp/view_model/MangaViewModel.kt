package sk.sandeep.animeapp.view_model

import androidx.lifecycle.ViewModel
import sk.sandeep.animeapp.repository.AnimeRepository

class MangaViewModel(
    private val repository: AnimeRepository
) : ViewModel() {
}