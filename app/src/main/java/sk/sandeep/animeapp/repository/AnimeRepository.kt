package sk.sandeep.animeapp.repository

import retrofit2.Response
import sk.sandeep.animeapp.data.remote.AnimeApi
import sk.sandeep.animeapp.data.remote.dto.TopAnimeApiResponse
import javax.inject.Inject

class AnimeRepository @Inject constructor(private val api: AnimeApi) {

    suspend fun getTopAnime(): Response<TopAnimeApiResponse> {
        return api.getTopAnimeList()
    }
}