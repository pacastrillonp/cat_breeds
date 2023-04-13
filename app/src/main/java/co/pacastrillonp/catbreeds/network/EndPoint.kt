package co.pacastrillonp.catbreeds.network


@Suppress("UNINITIALIZED_ENUM_COMPANION_WARNING")
enum class Endpoint(
    val path: String
) {
    Users(Endpoint.BREEDS);

    companion object {
        const val BREEDS = "breeds"

        fun get(encodedPath: String) =
            enumValues<Endpoint>().firstOrNull { encodedPath.endsWith(it.path) }
    }
}
