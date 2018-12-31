package pro.mousa.albums.data.model


class Album
{
    //NOTE: Gson can modify `val`s. So I'm defining all attributes as `val`s.
    val id: Long = 0L
    val userId: Long = 0L
    val title: String = ""
}
