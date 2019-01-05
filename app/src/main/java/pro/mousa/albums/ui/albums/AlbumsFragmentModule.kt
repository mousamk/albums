package pro.mousa.albums.ui.albums

import dagger.Module
import dagger.Provides
import pro.mousa.albums.data.DataManager
import pro.mousa.albums.utils.rx.SchedulerProvider


@Module
class AlbumsFragmentModule
{
    @Provides
    fun provideAlbumsViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider): AlbumsViewModel
        = AlbumsViewModel(dataManager, schedulerProvider)
}
