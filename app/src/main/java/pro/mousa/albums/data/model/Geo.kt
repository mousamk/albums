package pro.mousa.albums.data.model

import io.realm.RealmModel
import io.realm.annotations.RealmClass


@RealmClass
class Geo : RealmModel
{
    //NOTE: Gson can modify `val`s. So I'm defining all attributes as `val`s.
    private val lat: String = "0.0"
    private val lng: String = "0.0"

    //These two expose Double instead of original strings:
    val latitude:  Double get() = lat.toDoubleOrNull() ?: 0.0
    val longitude: Double get() = lng.toDoubleOrNull() ?: 0.0
}
