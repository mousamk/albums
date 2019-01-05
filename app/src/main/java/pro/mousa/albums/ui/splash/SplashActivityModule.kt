package pro.mousa.albums.ui.splash

import dagger.Module
import dagger.Provides
import pro.mousa.albums.data.DataManager
import pro.mousa.albums.utils.rx.SchedulerProvider


@Module
class SplashActivityModule
{
    @Provides
    fun provideSplashViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider): SplashViewModel
        = SplashViewModel(dataManager, schedulerProvider)
}
