package co.pacastrillonp.catbreeds.di

import co.pacastrillonp.catbreeds.persistence.persistenceModule
import co.pacastrillonp.catbreeds.ui.main.mainModule

val applicationModule = mainModule + persistenceModule