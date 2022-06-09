package sk.sandeep.animeapp.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import sk.sandeep.animeapp.data.remote.dto.TopAnimeApiResponse
import sk.sandeep.animeapp.util.Constants.BASE_URL

interface AnimeApi {

    @GET("v4/top/anime")
    suspend fun getTopAnimeList(): Response<TopAnimeApiResponse>

    companion object {
        fun create(): AnimeApi {
            val logger =
                HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(AnimeApi::class.java)
        }
    }
}