package pro.mousa.albums.data.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmModel
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass


@RealmClass
open class Photo : RealmModel
{
    //These real fields store the real data. They need to be mutable because of Realm:
    @PrimaryKey
    @SerializedName("id")
    private var idBack: Long = 0L
    @SerializedName("albumId")
    private var albumIdBack: Long = 0L
    @SerializedName("title")
    private var titleBack: String = ""
    @SerializedName("url")
    private var urlBack: String = ""
    @SerializedName("thumbnailUrl")
    private var thumbnailUrlBack: String = ""

    //These virtual attributes exist to provide an immutable interface:
    val id: Long get() = idBack
    val albumId: Long get() = albumIdBack
    val title: String get() = titleBack
    val url: String get() = urlBack
    val thumbnailUrl: String get() = thumbnailUrlBack


    companion object
    {
        const val FIELD_ALBUM_ID = "albumIdBack"  //NOTE: Keep this equal to the field name!
    }
}
