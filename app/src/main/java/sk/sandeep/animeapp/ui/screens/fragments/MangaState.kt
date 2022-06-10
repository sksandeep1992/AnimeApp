package sk.sandeep.animeapp.ui.screens.fragments

import sk.sandeep.animeapp.data.remote.dto.manga.Data

data class MangaState(
    val isLoading: Boolean = false,
    val manga: List<Data> = emptyList(),
    val error: String = ""
)