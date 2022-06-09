package sk.sandeep.animeapp.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response
import sk.sandeep.animeapp.data.remote.dto.TopAnimeApiResponse
import sk.sandeep.animeapp.repository.AnimeRepository
import sk.sandeep.animeapp.util.Resource

class AnimeViewModel(
    private val repository: AnimeRepository
) : ViewModel() {

    val topAnimeList: MutableLiveData<Resource<TopAnimeApiResponse>> = MutableLiveData()

    init {
        getTopAnimeData()
    }

    private fun getTopAnimeData() = viewModelScope.launch {
        topAnimeList.postValue(Resource.Loading())
        val response = repository.getTopAnime()
        topAnimeList.postValue(topAnimeResponseToResource(response))
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