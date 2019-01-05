package pro.mousa.albums.ui.albums

import pro.mousa.albums.data.model.Album
import pro.mousa.albums.ui.base.BaseNavigator


interface AlbumsNavigator : BaseNavigator
{
    fun showAlbum(album: Album)
}
