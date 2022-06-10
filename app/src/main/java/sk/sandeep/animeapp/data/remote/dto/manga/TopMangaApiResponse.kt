package sk.sandeep.animeapp.data.remote.dto.manga


import com.google.gson.annotations.SerializedName

data class TopMangaApiResponse(
    @SerializedName("data")
    val data: List<Data>,
    @SerializedName("pagination")
    val pagination: Pagination
)