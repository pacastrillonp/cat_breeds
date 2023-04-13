package co.pacastrillonp.catbreeds.model.mapper

import co.pacastrillonp.catbreeds.enviroment.Constants
import co.pacastrillonp.catbreeds.model.network.CatNetwork
import co.pacastrillonp.catbreeds.model.persistence.CatEntity

fun CatNetwork.catNetworkToCatEntity(): CatEntity? {

    val referenceImageId = referenceImageId ?: return null
    val breadName = name ?: ""
    val origin = origin ?: ""
    val affectionLevel = affectionLevel ?: 0
    val intelligence = intelligence ?: 0
    val imageUrl = String.format(Constants.Api.BASE_IMAGE_URL, referenceImageId)

    return CatEntity(
        referenceImageId = referenceImageId,
        breadName = breadName,
        origin = origin,
        affectionLevel = affectionLevel,
        intelligence = intelligence,
        imageUrl = imageUrl
    )
}