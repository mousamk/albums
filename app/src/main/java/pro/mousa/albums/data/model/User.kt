package pro.mousa.albums.data.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmModel
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.io.Serializable


@RealmClass
open class User : RealmModel, Serializable
{
    //These real fields store the real data. They need to be mutable because of Realm:
    @PrimaryKey
    @SerializedName("id")
    private var idBack: Long = 0L
    @SerializedName("name")
    private var nameBack: String = ""

    //These virtual attributes exist to provide an immutable interface:
    val id: Long get() = idBack
    val name: String get() = nameBack


    companion object
    {
        const val FIELD_ID = "idBack"     //NOTE: Keep this equal to the field name!
    }
}
