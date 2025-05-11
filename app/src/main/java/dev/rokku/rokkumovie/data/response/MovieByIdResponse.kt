package dev.rokku.rokkumovie.data.response


import com.google.gson.annotations.SerializedName
import dev.rokku.rokkumovie.presentation.data.model.MediaDetail

data class MovieByIdResponse(
    @SerializedName("adult")
    val adult: Boolean, // false
    @SerializedName("backdrop_path")
    val backdropPath: String, // /8rpDcsfLJypbO6vREc0547VKqEv.jpg
    @SerializedName("belongs_to_collection")
    val belongsToCollection: BelongsToCollection,
    @SerializedName("budget")
    val budget: Int, // 460000000
    @SerializedName("genres")
    val genres: List<Genre>?,
    @SerializedName("homepage")
    val homepage: String, // https://www.avatar.com/movies/avatar-the-way-of-water
    @SerializedName("id")
    val id: Int, // 76600
    @SerializedName("imdb_id")
    val imdbId: String, // tt1630029
    @SerializedName("origin_country")
    val originCountry: List<String>,
    @SerializedName("original_language")
    val originalLanguage: String, // en
    @SerializedName("original_title")
    val originalTitle: String, // Avatar: The Way of Water
    @SerializedName("overview")
    val overview: String, // Set more than a decade after the events of the first film, learn the story of the Sully family (Jake, Neytiri, and their kids), the trouble that follows them, the lengths they go to keep each other safe, the battles they fight to stay alive, and the tragedies they endure.
    @SerializedName("popularity")
    val popularity: Double, // 26.765
    @SerializedName("poster_path")
    val posterPath: String, // /t6HIqrRAclMCA60NsSmeqe9RmNV.jpg
    @SerializedName("production_companies")
    val productionCompanies: List<ProductionCompany>,
    @SerializedName("production_countries")
    val productionCountries: List<ProductionCountry>,
    @SerializedName("release_date")
    val releaseDate: String, // 2022-12-14
    @SerializedName("revenue")
    val revenue: Long, // 2320250281
    @SerializedName("runtime")
    val runtime: Int, // 192
    @SerializedName("spoken_languages")
    val spokenLanguages: List<SpokenLanguage>,
    @SerializedName("status")
    val status: String, // Released
    @SerializedName("tagline")
    val tagline: String, // Return to Pandora.
    @SerializedName("title")
    val title: String, // Avatar: The Way of Water
    @SerializedName("video")
    val video: Boolean, // false
    @SerializedName("vote_average")
    val voteAverage: Double, // 7.6
    @SerializedName("vote_count")
    val voteCount: Int // 12325
) {
    fun toMediaDetail(): MediaDetail {
        return MediaDetail(
            id = id,
            overview = overview,
            backdropPath = backdropPath,
            title = title,
            runtime = runtime.toString(),
            voteAverage = voteAverage,
            genres = genres ?: emptyList()
        )
    }
}