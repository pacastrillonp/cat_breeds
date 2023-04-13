package co.pacastrillonp.catbreeds.network

import co.pacastrillonp.catbreeds.model.network.regenerate.ListCatsNetworkItem
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface ApiProvider {

    @GET(Endpoint.BREEDS)
    fun getCasts(): Single<List<ListCatsNetworkItem>>

}