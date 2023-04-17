package co.pacastrillonp.catbreeds.model.mapper

import co.pacastrillonp.catbreeds.enviroment.Constants
import co.pacastrillonp.catbreeds.model.network.regenerate.ListCatsNetworkItem
import co.pacastrillonp.catbreeds.model.persistence.CatEntity

fun ListCatsNetworkItem.catNetworkToCatEntity(): CatEntity? {
    val referenceImageId = reference_image_id ?: return null
    val breadName = name
    val origin = origin
    val affectionLevel = affection_level
    val intelligence = intelligence
    val imageUrl = String.format(Constants.Api.BASE_IMAGE_URL, referenceImageId)

    return CatEntity(
        id = referenceImageId,
        breadName = breadName,
        origin = origin,
        affectionLevel = affectionLevel,
        intelligence = intelligence,
        imageUrl = imageUrl
    )
}

