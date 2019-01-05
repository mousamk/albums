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
        holder.previewImageView
        Picasso.get()
            .load(album.photos?.get(0)?.thumbnailUrl)
            .error(R.drawable.placeholder).placeholder(R.drawable.placeholder)
            .fit().centerCrop()
            .into(holder.previewImageView)
    }


    class AlbumViewHolder(root: View) : RecyclerView.ViewHolder(root)
    {
        internal val previewImageView: ImageView = itemView.findViewById(R.id.previewImageView)
        internal val albumNameView: TextView = itemView.findViewById(R.id.albumNameView)
        internal val userNameView: TextView = itemView.findViewById(R.id.userNameView)
    }
}
