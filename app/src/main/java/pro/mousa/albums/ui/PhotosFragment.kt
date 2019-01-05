package pro.mousa.albums.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pro.mousa.albums.R
import pro.mousa.albums.data.model.Album
import pro.mousa.albums.data.model.Photo

import kotlinx.android.synthetic.main.fragment_photos.*


class PhotosFragment : BaseFragment()
{
    private lateinit var album: Album

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

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        album = arguments!!.getSerializable(ARG_ALBUM) as Album
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedState: Bundle?): View?
    {
        return inflater.inflate(R.layout.fragment_photos, container, false)
    }

    override fun onViewCreated(view: View, savedState: Bundle?)
    {
        super.onViewCreated(view, savedState)
        showPhotos()
    }

    private fun showPhotos()
    {
        val photos = album.photos
        if (photos?.isEmpty() == true) {
            photosGridView?.visibility = View.INVISIBLE
            emptyNoteView?.visibility = View.VISIBLE
        }
        else {
            val photoAdapter = PhotoAdapter(context!!, photos!!) { interactionListener?.onPhotoClick(it) }
            photosGridView.adapter = photoAdapter
        }
    }


    interface InteractionListener
    {
        fun onPhotoClick(photo: Photo)
    }


    companion object
    {
        private const val ARG_ALBUM = "arg_album"

        fun newInstance(album: Album): PhotosFragment
        {
            val fragment = PhotosFragment()
            val args = Bundle()
            args.putSerializable(ARG_ALBUM, album)
            fragment.arguments = args
            return fragment
        }
    }
}
