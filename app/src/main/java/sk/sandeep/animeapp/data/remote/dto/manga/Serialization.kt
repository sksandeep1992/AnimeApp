package sk.sandeep.animeapp.data.remote.dto.manga


import com.google.gson.annotations.SerializedName

data class Serialization(
    @SerializedName("mal_id")
    val malId: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String
)