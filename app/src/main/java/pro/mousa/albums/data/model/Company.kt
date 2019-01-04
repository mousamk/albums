package pro.mousa.albums.data.model

import io.realm.RealmModel
import io.realm.annotations.RealmClass


@RealmClass
class Company : RealmModel
{
    //NOTE: Gson can modify `val`s. So I'm defining all attributes as `val`s.
    val name: String = ""
    val catchPhrase: String = ""
    val bs: String = ""
}
