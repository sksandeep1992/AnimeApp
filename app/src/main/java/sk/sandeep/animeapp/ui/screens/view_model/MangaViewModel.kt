package sk.sandeep.animeapp.ui.screens.view_model

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import sk.sandeep.animeapp.repository.AnimeRepository
import javax.inject.Inject

@HiltViewModel
class MangaViewModel @Inject constructor(
    private val repository: AnimeRepository
) : ViewModel() {
}