package pro.mousa.albums.data.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmModel
import io.realm.annotations.Ignore
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.io.Serializable


@RealmClass
open class Album : RealmModel, Serializable
{
    //These real fields store the real data. They need to be mutable because of Realm:
    @PrimaryKey
    @SerializedName("id")
    private var idBack: Long = 0L
    @SerializedName("userId")
    private var userIdBack: Long = 0L
    @SerializedName("title")
    private var titleBack: String = ""

    //These virtual attributes exist to provide an immutable interface:
    val id: Long get() = idBack
    val userId: Long get() = userIdBack
    val title: String get() = titleBack

    //These attributes will be linked for ease of access:
    @Ignore var user: User? = null
    @Ignore var photos: ArrayList<Photo>? = null
}
