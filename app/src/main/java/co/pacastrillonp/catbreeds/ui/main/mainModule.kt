package co.pacastrillonp.catbreeds.ui.main

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    viewModel { MainActivityViewModel(get(), get()) }
}
