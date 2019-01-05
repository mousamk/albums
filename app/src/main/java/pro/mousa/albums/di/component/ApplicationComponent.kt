package pro.mousa.albums.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import pro.mousa.albums.App
import pro.mousa.albums.di.builder.ActivityBuilder
import pro.mousa.albums.di.module.ApplicationModule


@Component(modules = [AndroidInjectionModule::class, ApplicationModule::class, ActivityBuilder::class])
interface ApplicationComponent
{
    fun inject(app: App)

    @Component.Builder
    interface Builder
    {
        @BindsInstance
        fun application(app: Application): Builder
        fun build(): ApplicationComponent
    }
}
