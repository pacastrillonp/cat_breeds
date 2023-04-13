package co.pacastrillonp.catbreeds.repository

import co.pacastrillonp.catbreeds.model.network.regenerate.ListCatsNetworkItem
import co.pacastrillonp.catbreeds.network.ApiProvider
import io.reactivex.rxjava3.core.Single

interface NetworkRepository {
    fun getCats(): Single<List<ListCatsNetworkItem>>
}

class DefaultNetworkRepository(private val apiProvider: ApiProvider) :
    NetworkRepository {

    override fun getCats(): Single<List<ListCatsNetworkItem>> = apiProvider.getCasts()
}