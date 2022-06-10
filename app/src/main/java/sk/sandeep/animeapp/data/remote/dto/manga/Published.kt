package sk.sandeep.animeapp.data.remote.dto.manga


import com.google.gson.annotations.SerializedName

data class Published(
    @SerializedName("from")
    val from: String,
    @SerializedName("prop")
    val prop: Prop,
    @SerializedName("string")
    val string: String,
    @SerializedName("to")
    val to: String
)