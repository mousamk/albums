package pro.mousa.albums.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import pro.mousa.albums.R
import pro.mousa.albums.data.model.Album
import pro.mousa.albums.data.model.Photo


class MainActivity : BaseActivity(),
                     AlbumsFragment.InteractionListener,
                     PhotosFragment.InteractionListener
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showAlbumsFragment()
    }

    private fun showAlbumsFragment()
    {
        val curFragment = supportFragmentManager.findFragmentById(R.id.main_fragment_holder)
        if (null != curFragment) return
        val fragment = AlbumsFragment.newInstance()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_fragment_holder, fragment)
            .commit()
        Log.d(TAG, "Added albums fragment.")
    }

    private fun showPhotosFragment(album: Album)
    {
        val fragment = PhotosFragment.newInstance(album)
        supportFragmentManager
            .beginTransaction()
            .add(R.id.main_fragment_holder, fragment)
            .addToBackStack(null)
            .commit()
        Log.d(TAG, "Added photos fragment.")
    }

    override fun onAlbumClick(album: Album)
    {
        showPhotosFragment(album)
    }

    override fun onPhotoClick(photo: Photo)
    {
        Toast.makeText(this, "Photo [${photo.title}] is clicked!", Toast.LENGTH_SHORT).show()
    }


    companion object
    {
        private val TAG: String = MainActivity::class.java.simpleName

        fun newIntent(context: Context) = Intent(context, MainActivity::class.java)
    }
}
