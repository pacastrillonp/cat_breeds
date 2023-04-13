package co.pacastrillonp.catbreeds.model.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CatNetwork(
    @field:Json(name = "adaptability") val adaptability: Int? = null,
    @field:Json(name = "affection_level") val affectionLevel: Int? = null,
    @field:Json(name = "alt_names") val altNames: String? = null,
    @field:Json(name = "cfa_url") val cfaUrl: String? = null,
    @field:Json(name = "child_friendly") val childFriendly: Int? = null,
    @field:Json(name = "country_code") val countryCode: String? = null,
    @field:Json(name = "country_codes") val countryCodes: String? = null,
    @field:Json(name = "description") val description: String? = null,
    @field:Json(name = "dog_friendly") val dogFriendly: Int? = null,
    @field:Json(name = "energy_level") val energyLevel: Int? = null,
    @field:Json(name = "experimental") val experimental: Int? = null,
    @field:Json(name = "grooming") val grooming: Int? = null,
    @field:Json(name = "hairless") val hairless: Int? = null,
    @field:Json(name = "health_issues") val healthIssues: Int? = null,
    @field:Json(name = "hypoallergenic") val hypoallergenic: Int? = null,
    @field:Json(name = "id") val id: String? = null,
    @field:Json(name = "indoor") val indoor: Int? = null,
    @field:Json(name = "intelligence") val intelligence: Int? = null,
    @field:Json(name = "lap") val lap: Int? = null,
    @field:Json(name = "life_span") val lifeSpan: String? = null,
    @field:Json(name = "name") val name: String? = null,
    @field:Json(name = "natural") val natural: Int? = null,
    @field:Json(name = "origin") val origin: String? = null,
    @field:Json(name = "rare") val rare: Int? = null,
    @field:Json(name = "reference_image_id") val referenceImageId: String? = null,
    @field:Json(name = "rex") val rex: Int? = null,
    @field:Json(name = "shedding_level") val sheddingLevel: Int? = null,
    @field:Json(name = "short_legs") val shortLegs: Int? = null,
    @field:Json(name = "social_needs") val socialNeeds: Int? = null,
    @field:Json(name = "stranger_friendly") val strangerFriendly: Int? = null,
    @field:Json(name = "suppressed_tail") val suppressedTail: Int? = null,
    @field:Json(name = "temperament") val temperament: String? = null,
    @field:Json(name = "vcahospitals_url") val vcahospitalsUrl: String? = null,
    @field:Json(name = "vetstreet_url") val vetstreetUrl: String? = null,
    @field:Json(name = "vocalisation") val vocalisation: Int? = null,
    @field:Json(name = "weight") val weight: Weight? = null,
    @field:Json(name = "wikipedia_url") val wikipediaUrl: String? = null
)