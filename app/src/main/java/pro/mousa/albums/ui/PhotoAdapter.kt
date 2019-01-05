package pro.mousa.albums.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import pro.mousa.albums.R
import pro.mousa.albums.data.model.Photo


class PhotoAdapter(context: Context,
                   private val photos: List<Photo>,
                   private val photoClickHandler: (Photo)->Unit) : BaseAdapter()
{
    private val layoutInflater = LayoutInflater.from(context)


    override fun getView(position: Int, oldView: View?, parent: ViewGroup?): View
    {
        val view = oldView ?: inflateView(parent)
        val holder = view.getTag(R.id.tag_viewholder) as PhotoViewHolder
        val photo = photos[position]
        Picasso.get()
            .load(photo.thumbnailUrl)
            .error(R.drawable.placeholder).placeholder(R.drawable.placeholder)
            .fit().centerInside()
            .into(holder.imageView)
        holder.nameView.text = photo.title
        holder.root.setOnClickListener { photoClickHandler(photo) }
        return view
    }

    private fun inflateView(parent: ViewGroup?): View
    {
        val view = layoutInflater.inflate(R.layout.item_photo, parent, false)
        val holder = PhotoViewHolder(view)
        view.setTag(R.id.tag_viewholder, holder)
        return view
    }

    override fun getItemId(position: Int) = 0L
    override fun getItem(position: Int) = photos[position]
    override fun getCount() = photos.size


    internal class PhotoViewHolder(internal val root: View)
    {
        internal val imageView: ImageView = root.findViewById(R.id.imageView)
        internal val nameView: TextView = root.findViewById(R.id.nameView)
    }
}
