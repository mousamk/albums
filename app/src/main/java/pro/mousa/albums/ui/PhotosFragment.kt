package pro.mousa.albums.ui

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import pro.mousa.albums.R
import pro.mousa.albums.data.model.Album
import pro.mousa.albums.data.model.Photo

import kotlinx.android.synthetic.main.fragment_photos.*


class PhotosFragment : BaseFragment()
{
    private lateinit var album: Album
    private var currentImageShowing = false


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
        prepareViews()
        showPhotosOrEmptyNote()
    }

    private fun prepareViews()
    {
        currentImageView?.setOnClickListener { onCurrentPhotoClick() }
    }

    private fun showPhotosOrEmptyNote()
    {
        val photos = album.photos
        if (photos?.isEmpty() == true)
            showEmptyNote()
        else
            showPhotos(photos!!)
    }

    private fun showEmptyNote()
    {
        photosGridView?.visibility = View.INVISIBLE
        emptyNoteView?.visibility = View.VISIBLE
    }

    private fun showPhotos(photos: List<Photo>)
    {
        val photoAdapter = PhotoAdapter(context!!, photos, ::onPhotoClick)
        photosGridView.adapter = photoAdapter
    }

    private fun onPhotoClick(photo: Photo)
    {
        setFullHeightToCurrentImageView()
        setCurrentImage(photo)
        animateCurrentImageViewIn()
    }

    private fun setCurrentImage(photo: Photo)
    {
        currentImageView?.post {
            Picasso.get()
                .load(photo.url)
                .error(R.drawable.placeholder).placeholder(R.drawable.placeholder)
                .fit().centerInside()
                .into(currentImageView)
        }
    }

    private fun animateCurrentImageViewIn()
    {
        val height = (view?.height ?: 0).toFloat()
        ObjectAnimator.ofFloat(currentImageView, "translationY", -height).apply {
            duration = 500
            start()
        }
        currentImageShowing = true
    }

    private fun animateCurrentImageViewOut()
    {
        val height = (view?.height ?: 0).toFloat()
        ObjectAnimator.ofFloat(currentImageView, "translationY", height).apply {
            duration = 500
            start()
        }
        currentImageShowing = false
    }

    private fun setFullHeightToCurrentImageView()
    {
        val height = view?.height ?: 0
        val params = currentImageView.layoutParams
        params.height = height
        currentImageView.layoutParams = params
    }

    private fun onCurrentPhotoClick()
    {
        animateCurrentImageViewOut()
    }

    override fun handleBackPress(): Boolean
    {
        if (currentImageShowing) {
            onCurrentPhotoClick()
            return true
        }
        return false
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
