package sk.sandeep.animeapp.data.remote

import retrofit2.Response
import retrofit2.http.GET
import sk.sandeep.animeapp.data.remote.dto.TopAnimeApiResponse

interface AnimeApi {

    @GET("v4/top/anime")
    suspend fun getTopAnimeList(): Response<TopAnimeApiResponse>

    /** For without Dagger Hilt  */
    /* companion object {
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
     }*/
}