package pro.mousa.albums.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import pro.mousa.albums.R
import pro.mousa.albums.data.model.Album


class MainActivity : BaseActivity(), AlbumsFragment.InteractionListener
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
        Log.d(TAG, "Added albums fragment!")
    }

    override fun onAlbumClick(album: Album)
    {
        Toast.makeText(this, "Album ${album.title} is clicked!", Toast.LENGTH_SHORT).show()
    }


    companion object
    {
        private val TAG: String = MainActivity::class.java.simpleName

        fun newIntent(context: Context) = Intent(context, MainActivity::class.java)
    }
}
