package co.pacastrillonp.catbreeds.repository

import co.pacastrillonp.catbreeds.model.network.CatNetwork
import co.pacastrillonp.catbreeds.network.ApiProvider
import io.reactivex.rxjava3.core.Single

interface NetworkRepository {
    fun getUsers(): Single<List<CatNetwork>>
}

class DefaultNetworkRepository(private val apiProvider: ApiProvider) :
    NetworkRepository {

    override fun getUsers(): Single<List<CatNetwork>> = apiProvider.getCasts()
}