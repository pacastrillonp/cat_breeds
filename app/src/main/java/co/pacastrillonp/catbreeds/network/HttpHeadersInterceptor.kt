package co.pacastrillonp.catbreeds.network

import co.pacastrillonp.catbreeds.network.HeaderName.ACCEPT
import co.pacastrillonp.catbreeds.network.HeaderName.AUTHORIZATION
import co.pacastrillonp.catbreeds.network.HeaderName.CONTENT_TYPE
import co.pacastrillonp.catbreeds.network.HeaderName.USER_AGENT
import co.pacastrillonp.catbreeds.network.HeaderValue.ANDROID
import co.pacastrillonp.catbreeds.network.HeaderValue.JSON
import okhttp3.Headers
import okhttp3.Headers.Companion.toHeaders
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Response

class HttpHeadersInterceptor(private val httpHeaderSigner: HttpHeaderSigner) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val headers = createHeaders(original.url)

        val request = original.newBuilder()
            .headers(headers)
            .build()

        return chain.proceed(request)
    }

    private fun createHeaders(url: HttpUrl): Headers {
        val headers = mutableMapOf(
            ACCEPT to JSON,
            CONTENT_TYPE to JSON,
            USER_AGENT to ANDROID
        )

        Endpoint.get(url.encodedPath)?.let {
            createAuthenticationHeader(it.authentication)
        }?.let {
            headers[AUTHORIZATION] = it
        }

        return headers.toHeaders()
    }

    private fun createAuthenticationHeader(
        type: Authentication
    ): String? {
        return when (type) {
            Authentication.XApiKey -> {
                httpHeaderSigner.xApiKey()
            }
            Authentication.None -> null
        }
    }
}

/**
 * Key names used in HTTP headers
 */
object HeaderName {
    const val ACCEPT = "Accept"
    const val CONTENT_TYPE = "Content-Type"
    const val USER_AGENT = "User-Agent"
    const val AUTHORIZATION = "X-Api-Key"
}

/**
 * Values used in HTTP headers
 */
object HeaderValue {
    const val JSON = "application/json"
    const val ANDROID = "Android"
}