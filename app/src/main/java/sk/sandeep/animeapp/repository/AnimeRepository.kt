package sk.sandeep.animeapp.repository

import retrofit2.Response
import sk.sandeep.animeapp.data.remote.AnimeApi
import sk.sandeep.animeapp.data.remote.dto.anime.TopAnimeApiResponse
import sk.sandeep.animeapp.data.remote.dto.manga.TopMangaApiResponse
import javax.inject.Inject

class AnimeRepository @Inject constructor(private val api: AnimeApi) {

    suspend fun getTopAnime(): Response<TopAnimeApiResponse> {
        return api.getTopAnimeList()
    }

    suspend fun getTopManga(): Response<TopMangaApiResponse> {
        return api.getTopMangaList()
    }
}