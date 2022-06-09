package sk.sandeep.animeapp.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Licensor(
    @SerializedName("mal_id")
    val malId: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String
)