package sk.sandeep.animeapp.data.remote.dto.manga


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("authors")
    val authors: List<Author>,
    @SerializedName("background")
    val background: String,
    @SerializedName("chapters")
    val chapters: Int,
    @SerializedName("demographics")
    val demographics: List<Demographic>,
    @SerializedName("explicit_genres")
    val explicitGenres: List<Any>,
    @SerializedName("favorites")
    val favorites: Int,
    @SerializedName("genres")
    val genres: List<Genre>,
    @SerializedName("images")
    val images: Images,
    @SerializedName("mal_id")
    val malId: Int,
    @SerializedName("members")
    val members: Int,
    @SerializedName("popularity")
    val popularity: Int,
    @SerializedName("published")
    val published: Published,
    @SerializedName("publishing")
    val publishing: Boolean,
    @SerializedName("rank")
    val rank: Int,
    @SerializedName("score")
    val score: Double,
    @SerializedName("scored")
    val scored: Double,
    @SerializedName("scored_by")
    val scoredBy: Int,
    @SerializedName("serializations")
    val serializations: List<Serialization>,
    @SerializedName("status")
    val status: String,
    @SerializedName("synopsis")
    val synopsis: String,
    @SerializedName("themes")
    val themes: List<Theme>,
    @SerializedName("title")
    val title: String,
    @SerializedName("title_english")
    val titleEnglish: String,
    @SerializedName("title_japanese")
    val titleJapanese: String,
    @SerializedName("title_synonyms")
    val titleSynonyms: List<String>,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("volumes")
    val volumes: Int
)