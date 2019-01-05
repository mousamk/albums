package pro.mousa.albums.data.local

import android.app.Application
import android.util.Log
import io.reactivex.Single
import io.realm.Realm
import io.realm.RealmConfiguration
import pro.mousa.albums.data.NotFoundException
import pro.mousa.albums.data.model.Album
import pro.mousa.albums.data.model.Photo
import pro.mousa.albums.data.model.User
import javax.inject.Inject


class AppDbHelper @Inject constructor(application: Application) : DbHelper
{
    private var realmConfig: RealmConfiguration


    init {
        Realm.init(application)
        realmConfig = RealmConfiguration.Builder()
            .schemaVersion(1)
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(realmConfig)
    }

    override fun saveAlbums(albums: List<Album>): Single<Boolean>
    {
        return Single.fromCallable {
            runTransaction { realm ->
                realm.beginTransaction()
                realm.where(Album::class.java).findAll().deleteAllFromRealm()
                realm.copyToRealm(albums)
                realm.commitTransaction()
                Log.i(TAG, "Saved ${albums.size} albums.")
                true
            }
        }
    }

    override fun savePhotos(photos: List<Photo>): Single<Boolean>
    {
        return Single.fromCallable {
            runTransaction { realm ->
                realm.beginTransaction()
                realm.where(Photo::class.java).findAll().deleteAllFromRealm()
                realm.copyToRealm(photos)
                realm.commitTransaction()
                Log.i(TAG, "Saved ${photos.size} photos.")
                true
            }
        }
    }

    override fun saveUsers(users: List<User>): Single<Boolean>
    {
        return Single.fromCallable {
            runTransaction { realm ->
                realm.beginTransaction()
                realm.where(User::class.java).findAll().deleteAllFromRealm()
                realm.copyToRealm(users)
                realm.commitTransaction()
                Log.i(TAG, "Saved ${users.size} users.")
                true
            }
        }
    }

    override fun loadAlbums(): Single<List<Album>>
    {
        return Single.fromCallable {
            runTransaction<List<Album>> { realm ->
                val albums = realm.where(Album::class.java).findAll()
                realm.copyFromRealm(albums)
            }
        }
    }

    override fun loadPhotosByAlbum(albumId: Long): Single<List<Photo>>
    {
        return Single.fromCallable {
            runTransaction<List<Photo>> { realm ->
                val photos = realm.where(Photo::class.java).equalTo(Photo.FIELD_ALBUM_ID, albumId).findAll()
                realm.copyFromRealm(photos)
            }
        }
    }

    override fun loadUserById(userId: Long): Single<User>
    {
        return Single.fromCallable {
            runTransaction { realm ->
                val user = realm.where(User::class.java).equalTo(User.FIELD_ID, userId).findFirst()
                user?.let { realm.copyFromRealm(it) } ?: throw NotFoundException()
            }
        }
    }

    private fun<T> runTransaction(runnable: (Realm)->T): T
    {
        val realm = getRealm()
        val ret = runnable(realm)
        realm.close()
        return ret
    }

    private fun getRealm(): Realm
    {
        return try { Realm.getDefaultInstance() }
        catch (e: Throwable) {
            Log.w(TAG, "Realm error opening db: ${e.message}\nGoing to delete existing db and try again...")
            Realm.deleteRealm(realmConfig)
            Realm.getDefaultInstance()
        }
    }


    companion object
    {
        private val TAG = AppDbHelper::class.java.simpleName
    }
}
