package dev.rokku.rokkumovie.data.response.serie


import com.google.gson.annotations.SerializedName

data class LastEpisodeToAir(
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("overview")
    val overview: String? = "",
    @SerializedName("vote_average")
    val voteAverage: Int? = 0,
    @SerializedName("vote_count")
    val voteCount: Int? = 0,
    @SerializedName("air_date")
    val airDate: String? = "",
    @SerializedName("episode_number")
    val episodeNumber: Int? = 0,
    @SerializedName("episode_type")
    val episodeType: String? = "",
    @SerializedName("production_code")
    val productionCode: String? = "",
    @SerializedName("runtime")
    val runtime: Int? = 0,
    @SerializedName("season_number")
    val seasonNumber: Int? = 0,
    @SerializedName("show_id")
    val showId: Int? = 0,
    @SerializedName("still_path")
    val stillPath: String? = ""
)