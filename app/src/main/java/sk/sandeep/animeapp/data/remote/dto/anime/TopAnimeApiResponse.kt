package sk.sandeep.animeapp.data.remote.dto.anime


import com.google.gson.annotations.SerializedName

data class TopAnimeApiResponse(
    @SerializedName("data")
    val data: List<Data>,
    @SerializedName("pagination")
    val pagination: Pagination
)