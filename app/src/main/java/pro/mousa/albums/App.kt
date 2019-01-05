package pro.mousa.albums

import android.app.Activity
import android.app.Application
import pro.mousa.albums.di.component.ApplicationComponent
import pro.mousa.albums.di.component.DaggerApplicationComponent
import pro.mousa.albums.di.module.ApplicationModule
import javax.inject.Inject


class App : Application()
{
    private lateinit var applicationComponent: ApplicationComponent
    val component: ApplicationComponent get() = applicationComponent


    override fun onCreate()
    {
        super.onCreate()
        prepareApplicationComponent()
    }

    private fun prepareApplicationComponent()
    {
        applicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

}
