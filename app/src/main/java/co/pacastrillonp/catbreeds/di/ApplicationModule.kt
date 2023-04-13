package co.pacastrillonp.catbreeds.di

import co.pacastrillonp.catbreeds.network.networkModule
import co.pacastrillonp.catbreeds.persistence.persistenceModule
import co.pacastrillonp.catbreeds.repository.repositoryModule
import co.pacastrillonp.catbreeds.ui.main.mainModule

val applicationModule = mainModule + persistenceModule + networkModule + repositoryModule