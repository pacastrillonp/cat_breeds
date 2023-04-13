package co.pacastrillonp.catbreeds.network

import co.pacastrillonp.catbreeds.enviroment.Constants

interface HttpHeaderSigner {
    fun xApiKey(): String
}

class CryptoHttpHeaderSigner : HttpHeaderSigner {
    override fun xApiKey(): String = Constants.Api.API_KEY

}