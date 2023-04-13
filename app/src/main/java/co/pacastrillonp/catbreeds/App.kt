package co.pacastrillonp.catbreeds

import android.app.Application
import co.pacastrillonp.catbreeds.di.applicationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext

class App : Application(){
    override fun onCreate() {
        super.onCreate()
        GlobalContext.startKoin {
            androidContext(this@App)
            modules(applicationModule)
        }
    }
}