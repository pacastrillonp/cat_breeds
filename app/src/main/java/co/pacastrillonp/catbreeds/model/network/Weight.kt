package co.pacastrillonp.catbreeds.model.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Weight(
    @field:Json(name = "imperial") val imperial: String? = null,
    @field:Json(name = "metric") val metric: String? = null
)