package kr.co.example.codingtest_kakaocme.vo

import com.google.gson.annotations.SerializedName
import kr.co.example.codingtest_kakaocme.api.SendType

data class Body(
    @SerializedName("documents")
    val documents: List<Document> = listOf(),
    @SerializedName("meta")
    val meta: Meta
)

data class Document(
    @SerializedName("collection")
    val collection: String = "",
    @SerializedName("datetime")
    val dateTime: String = "",
    @SerializedName("display_sitename")
    val displaySiteName: String = "",
    @SerializedName("doc_url")
    val docUrl: String = "",
    @SerializedName("image_url")
    val imageUrl: String = "",
    @SerializedName("thumbnail_url")
    val thumbnailUrl: String = "",
    @SerializedName("height")
    val height: Int = 0,
    @SerializedName("width")
    val width: Int = 0
)

data class Meta(
    @SerializedName("is_end")
    val is_end: Boolean = false,
    @SerializedName("pageable_count")
    val pageableCount: Int = 0,
    @SerializedName("total_count")
    val totalCount: Int = 0
)

