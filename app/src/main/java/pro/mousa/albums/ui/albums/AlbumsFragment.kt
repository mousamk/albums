package pro.mousa.albums.ui.albums

import android.widget.Toast
import pro.mousa.albums.BR
import pro.mousa.albums.R
import pro.mousa.albums.data.model.Album
import pro.mousa.albums.ui.base.BaseFragment
import javax.inject.Inject


class AlbumsFragment : BaseFragment<FragmentAlbumsBinding, AlbumsViewModel>(), AlbumsNavigator
{
    @Inject internal lateinit var albumsViewModel: AlbumsViewModel

    override val viewModel: AlbumsViewModel
        get() = albumsViewModel

    override val layoutId: Int
        get() = R.layout.fragment_albums

    override val bindingVariable: Int
        get() = BR.viewModel


    override fun showAlbum(album: Album)
    {
        //TODO: ...
        Toast.makeText(context, "Show album [${album.title}]!", Toast.LENGTH_SHORT).show()
    }
}
