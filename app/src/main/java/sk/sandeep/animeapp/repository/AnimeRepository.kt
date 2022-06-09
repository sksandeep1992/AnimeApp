package sk.sandeep.animeapp.repository

import retrofit2.Response
import sk.sandeep.animeapp.data.remote.AnimeApi
import sk.sandeep.animeapp.data.remote.dto.TopAnimeApiResponse

class AnimeRepository() {

    suspend fun getTopAnime(): Response<TopAnimeApiResponse> {
        return AnimeApi.create().getTopAnimeList()
    }
}