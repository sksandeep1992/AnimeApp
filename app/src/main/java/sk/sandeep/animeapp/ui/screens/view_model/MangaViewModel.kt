package sk.sandeep.animeapp.ui.screens.view_model

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import sk.sandeep.animeapp.data.remote.dto.manga.TopMangaApiResponse
import sk.sandeep.animeapp.repository.AnimeRepository
import sk.sandeep.animeapp.ui.screens.fragments.MangaState
import sk.sandeep.animeapp.util.Resource
import javax.inject.Inject

@HiltViewModel
class MangaViewModel @Inject constructor(
    private val repository: AnimeRepository
) : ViewModel() {
    private val _topMangaList = mutableStateOf(MangaState())
    val topMangaList: State<MangaState> = _topMangaList

    init {
        getTopMangaData()
    }

    private fun getTopMangaData() = viewModelScope.launch {

        when (val result = topMangaResponseToResource(repository.getTopManga())) {
            is Resource.Error -> {
                _topMangaList.value = MangaState(
                    error = result.message ?: "An unexpected error occured"
                )
            }
            is Resource.Loading -> {
                _topMangaList.value = MangaState(isLoading = true)
            }
            is Resource.Success -> {
                _topMangaList.value = MangaState(manga = result.data!!.data)
            }
        }
    }

    private fun topMangaResponseToResource(response: Response<TopMangaApiResponse>)
            : Resource<TopMangaApiResponse> {
        if (response.isSuccessful) {
            response.body()?.let { topMangaResponse ->
                return Resource.Success(topMangaResponse)
            }
        }
        return Resource.Error(response.message())
    }
}