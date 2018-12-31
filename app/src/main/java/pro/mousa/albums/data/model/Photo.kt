package pro.mousa.albums.data.model


class Photo
{
    //NOTE: Gson can modify `val`s. So I'm defining all attributes as `val`s.
    val id: Long = 0L
    val albumId: Long = 0L
    val title: String = ""
    val url: String = ""
    val thumbnailUrl: String = ""
}
