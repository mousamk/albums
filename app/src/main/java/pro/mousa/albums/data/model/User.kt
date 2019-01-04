package pro.mousa.albums.data.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmModel
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass


@RealmClass
class User : RealmModel
{
    //NOTE: Gson can modify `val`s. So I'm defining all attributes as `val`s.
    @PrimaryKey
    val id: Long = 0L
    val name: String = ""
    val username: String = ""
    val email: String = ""
    @SerializedName("address")
    private lateinit var addressBack: Address
    val phone: String = ""
    val website: String = ""
    @SerializedName("company")
    private lateinit var companyBack: Company

    //These are to expose immutable objects instead of the mutable original ones:
    val address: Address get() = addressBack
    val company: Company get() = companyBack


    companion object
    {
        val FIELD_ID = "id"     //NOTE: Keep this equal to the field name!
    }
}
