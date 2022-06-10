package sk.sandeep.animeapp.ui.screens.view_model

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import sk.sandeep.animeapp.data.remote.dto.TopAnimeApiResponse
import sk.sandeep.animeapp.repository.AnimeRepository
import sk.sandeep.animeapp.ui.screens.fragments.AnimeState
import sk.sandeep.animeapp.util.Resource
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(
    private val repository: AnimeRepository
) : ViewModel() {

    private val _topAnimeList = mutableStateOf(AnimeState())
    val topAnimeList: State<AnimeState> = _topAnimeList

    init {
        getTopAnimeData()
    }

    private fun getTopAnimeData() = viewModelScope.launch {

        when (val result = topAnimeResponseToResource(repository.getTopAnime())) {
            is Resource.Error -> {
                _topAnimeList.value = AnimeState(
                    error = result.message ?: "An unexpected error occured"
                )
            }
            is Resource.Loading -> {
                _topAnimeList.value = AnimeState(isLoading = true)
            }
            is Resource.Success -> {
                _topAnimeList.value = AnimeState(anime = result.data!!.data)
            }
        }
    }

    private fun topAnimeResponseToResource(response: Response<TopAnimeApiResponse>)
            : Resource<TopAnimeApiResponse> {
        if (response.isSuccessful) {
            response.body()?.let { topAnimeResponse ->
                return Resource.Success(topAnimeResponse)
            }
        }
        return Resource.Error(response.message())
    }
}