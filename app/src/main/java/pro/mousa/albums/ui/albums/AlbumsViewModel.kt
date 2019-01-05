package pro.mousa.albums.ui.albums

import pro.mousa.albums.data.DataManager
import pro.mousa.albums.data.model.Album
import pro.mousa.albums.ui.base.BaseViewModel
import pro.mousa.albums.utils.rx.SchedulerProvider


class AlbumsViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider)
    : BaseViewModel<AlbumsNavigator>(dataManager, schedulerProvider)
{
    fun onAlbumClick(album: Album)
    {
        navigator?.showAlbum(album)
    }
}
