package pro.mousa.albums.ui.main

import android.arch.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import pro.mousa.albums.ViewModelProviderFactory
import pro.mousa.albums.data.DataManager
import pro.mousa.albums.utils.rx.SchedulerProvider


@Module
class MainActivityModule
{
    @Provides
    fun provideMainViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider): MainViewModel
        = MainViewModel(dataManager, schedulerProvider)

    @Provides
    fun provideMainViewModelProvider(mainViewModel: MainViewModel): ViewModelProvider.Factory
        = ViewModelProviderFactory(mainViewModel)
}
