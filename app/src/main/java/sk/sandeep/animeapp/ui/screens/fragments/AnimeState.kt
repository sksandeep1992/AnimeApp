package sk.sandeep.animeapp.ui.screens.fragments

import sk.sandeep.animeapp.data.remote.dto.Data

data class AnimeState(
    val isLoading: Boolean = false,
    val anime: List<Data> = emptyList(),
    val error: String = ""
)