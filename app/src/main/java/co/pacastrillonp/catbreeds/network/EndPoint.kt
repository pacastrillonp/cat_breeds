package co.pacastrillonp.catbreeds.network

enum class Authentication {
    XApiKey, None
}

@Suppress("UNINITIALIZED_ENUM_COMPANION_WARNING")
enum class Endpoint(
    val path: String,
    val authentication: Authentication
) {
    Cats(Endpoint.BREEDS, Authentication.XApiKey);
    companion object {
        const val BREEDS = "breeds"

        fun get(encodedPath: String) =
            enumValues<Endpoint>().firstOrNull { encodedPath.endsWith(it.path) }
    }
}
