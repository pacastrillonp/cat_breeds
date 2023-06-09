package co.pacastrillonp.catbreeds.repository

import org.koin.dsl.module

val repositoryModule = module {
    single<NetworkRepository> { DefaultNetworkRepository(get()) }
}