package pro.mousa.albums.data.model

import io.realm.RealmModel
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass


@RealmClass
class Photo : RealmModel
{
    //NOTE: Gson can modify `val`s. So I'm defining all attributes as `val`s.
    @PrimaryKey
    val id: Long = 0L
    val albumId: Long = 0L
    val title: String = ""
    val url: String = ""
    val thumbnailUrl: String = ""


    companion object
    {
        val FIELD_ALBUM_ID = "albumId"  //NOTE: Keep this equal to the field name!
    }
}
