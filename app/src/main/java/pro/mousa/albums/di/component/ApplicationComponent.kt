package pro.mousa.albums.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import pro.mousa.albums.data.ui.BaseActivity
import pro.mousa.albums.di.module.ApplicationModule


@Component(modules = [ApplicationModule::class])
interface ApplicationComponent
{
    fun inject(activity: BaseActivity)

    @Component.Builder
    interface Builder
    {
        @BindsInstance
        fun application(app: Application): Builder
        fun build(): ApplicationComponent
    }
}
