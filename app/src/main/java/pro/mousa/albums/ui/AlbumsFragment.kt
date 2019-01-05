package pro.mousa.albums.ui

import android.widget.Toast
import pro.mousa.albums.data.model.Album


class AlbumsFragment : BaseFragment()
{
    fun showAlbum(album: Album)
    {
        //TODO: ...
        Toast.makeText(context, "Show album [${album.title}]!", Toast.LENGTH_SHORT).show()
    }
}
