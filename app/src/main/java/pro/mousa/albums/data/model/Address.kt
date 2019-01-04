package pro.mousa.albums.data.model

import io.realm.RealmModel
import io.realm.annotations.RealmClass


@RealmClass
class Address : RealmModel
{
    //NOTE: Gson can modify `val`s. So I'm defining all attributes as `val`s.
    val street: String = ""
    val suite: String = ""
    val city: String = ""
    val zipcode: String = ""
    private lateinit var geo: Geo

    //This is to expose an immutable object instead of the mutable original one:
    val location: Geo get() = geo
}
