package pro.mousa.albums

import android.app.Application


class App : Application()
{
    private lateinit var applicationComponent: ApplicationComponent
    //To hide mutability of the original variable:
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
