package pro.mousa.albums.di.component

import dagger.Component
import pro.mousa.albums.di.module.ApplicationModule
import pro.mousa.albums.ui.BaseActivity
import pro.mousa.albums.ui.BaseFragment
import javax.inject.Singleton


@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent
{
    fun inject(activity: BaseActivity)
    fun inject(fragment: BaseFragment)
}
