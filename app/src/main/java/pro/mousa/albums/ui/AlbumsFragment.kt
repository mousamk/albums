package pro.mousa.albums.ui

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pro.mousa.albums.R
import pro.mousa.albums.data.model.Album

import kotlinx.android.synthetic.main.fragment_albums.*


class AlbumsFragment : BaseFragment()
{
    private var albumAdapter: AlbumAdapter? = null
    private lateinit var albums: List<Album>
    private var interactionListener: InteractionListener? = null


    override fun onAttach(context: Context?)
    {
        super.onAttach(context)
        val candidates = arrayOf(parentFragment, targetFragment, getContext())
        for (parent in candidates)
            if (parent is InteractionListener) {
                interactionListener = parent
                return
            }
    }

    override fun onDetach()
    {
        super.onDetach()
        interactionListener = null
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedState: Bundle?): View?
    {
        return inflater.inflate(R.layout.fragment_albums, container, false)
    }

    override fun onViewCreated(view: View, savedState: Bundle?)
    {
        super.onViewCreated(view, savedState)
        loadData()
    }

    private fun loadData()
    {
        val disposable = dataManager.getAlbums().subscribe { albums: List<Album> ->
            this@AlbumsFragment.albums = albums
            if (albums.isEmpty())
                showEmptyNote()
            else
                showAlbumsList()
        }
        disposables.add(disposable)
    }

    private fun showEmptyNote()
    {
        emptyNoteView?.visibility = View.VISIBLE
        albumsRecyclerView?.visibility = View.INVISIBLE
    }

    private fun showAlbumsList()
    {
        albumAdapter = AlbumAdapter(context!!, albums) { interactionListener?.onAlbumClick(it) }
        albumsRecyclerView?.layoutManager = LinearLayoutManager(context)
        albumsRecyclerView.adapter = albumAdapter
    }


    interface InteractionListener
    {
        fun onAlbumClick(album: Album)
    }


    companion object
    {
        fun newInstance(): AlbumsFragment
        {
            return AlbumsFragment()
        }
    }
}
