package pro.mousa.albums.data.model

import io.realm.RealmModel
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass


@RealmClass
class Album : RealmModel
{
    //NOTE: Gson can modify `val`s. So I'm defining all attributes as `val`s.
    @PrimaryKey
    val id: Long = 0L
    val userId: Long = 0L
    val title: String = ""
}
