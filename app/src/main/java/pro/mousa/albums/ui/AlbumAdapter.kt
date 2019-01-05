package pro.mousa.albums.ui

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import pro.mousa.albums.R
import pro.mousa.albums.data.model.Album


class AlbumAdapter(context: Context,
                   private val albums: List<Album>,
                   private val albumClickHandler: (Album)->Unit)
    : RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>()
{
    private val layoutInflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater


    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): AlbumViewHolder
    {
        val view = layoutInflater.inflate(R.layout.item_album, parent, false)
        return AlbumViewHolder(view)
    }

    override fun getItemCount() = albums.size

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int)
    {
        val album = albums[position]
        holder.albumNameView.text = album.title
        holder.userNameView.text = album.user?.name ?: "User ID ${album.userId}"
        setPhotos(holder, album)
        holder.itemView.setOnClickListener { albumClickHandler(album) }
    }

    private fun setPhotos(holder: AlbumViewHolder, album: Album)
    {
        album.photos?.let { photos ->
            if (photos.isNotEmpty()) {
                Picasso.get()
                    .load(photos[0].thumbnailUrl)
                    .error(R.drawable.placeholder).placeholder(R.drawable.placeholder)
                    .fit().centerCrop()
                    .into(holder.previewImageView1)
            }
            if (photos.size > 1) {
                holder.previewImageView2.visibility = View.VISIBLE
                Picasso.get()
                    .load(photos[1].thumbnailUrl)
                    .error(R.drawable.placeholder).placeholder(R.drawable.placeholder)
                    .fit().centerCrop()
                    .into(holder.previewImageView2)
            }
            else
                holder.previewImageView2.visibility = View.GONE
            if (photos.size > 2) {
                holder.previewImageView3.visibility = View.VISIBLE
                Picasso.get()
                    .load(photos[2].thumbnailUrl)
                    .error(R.drawable.placeholder).placeholder(R.drawable.placeholder)
                    .fit().centerCrop()
                    .into(holder.previewImageView3)
            }
            else
                holder.previewImageView3.visibility = View.GONE
        }
    }


    class AlbumViewHolder(root: View) : RecyclerView.ViewHolder(root)
    {
        internal val previewImageView1: ImageView = itemView.findViewById(R.id.previewImageView1)
        internal val previewImageView2: ImageView = itemView.findViewById(R.id.previewImageView2)
        internal val previewImageView3: ImageView = itemView.findViewById(R.id.previewImageView3)
        internal val albumNameView: TextView = itemView.findViewById(R.id.albumNameView)
        internal val userNameView: TextView = itemView.findViewById(R.id.userNameView)
    }
}
