package sk.sandeep.animeapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sk.sandeep.animeapp.data.remote.AnimeApi
import sk.sandeep.animeapp.repository.AnimeRepository
import sk.sandeep.animeapp.util.Constants
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePokemonApi(): AnimeApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AnimeApi::class.java)
    }

    @Provides
    @Singleton
    fun provideAnimeRepository(api: AnimeApi): AnimeRepository {
            return AnimeRepository(api)
    }
}