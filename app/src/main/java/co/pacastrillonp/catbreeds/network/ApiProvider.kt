package co.pacastrillonp.catbreeds.network

import co.pacastrillonp.catbreeds.enviroment.Constants.Api.API_KEY
import co.pacastrillonp.catbreeds.enviroment.Constants.Api.HEADER_X_API_KEY
import co.pacastrillonp.catbreeds.model.network.CatNetwork
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiProvider {

    @Headers(HEADER_X_API_KEY + API_KEY)
    @GET(Endpoint.BREEDS)
    fun getCasts(): Single<List<CatNetwork>>

}