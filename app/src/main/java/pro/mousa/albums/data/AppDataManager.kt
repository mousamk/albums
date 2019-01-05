package pro.mousa.albums.data

import io.reactivex.Single
import pro.mousa.albums.data.local.DbHelper
import pro.mousa.albums.data.model.Album
import pro.mousa.albums.data.model.Photo
import pro.mousa.albums.data.remote.ApiHelper
import javax.inject.Inject


class AppDataManager @Inject constructor(private val dbHelper: DbHelper,
                                         private val apiHelper: ApiHelper) : DataManager
{
    override fun getAlbums(): Single<List<Album>>
    {
        return dbHelper.loadAlbums().map { albums ->
            if (albums.isNotEmpty()) albums
            else apiHelper.getAlbums().blockingGet()
        }
    }

    override fun getAlbumPhotos(albumId: Long): Single<List<Photo>>
    {
        return dbHelper.loadPhotosByAlbum(albumId).map { photos ->
            if (photos.isNotEmpty()) photos
            else apiHelper.getPhotos().blockingGet().filter { it.albumId == albumId }
        }
    }

    override fun downloadData(): Single<Boolean>
    {
        return apiHelper.getUsers().flatMap {
            apiHelper.getAlbums().flatMap {
                apiHelper.getPhotos().flatMap { Single.just(true) }
            }
        }.subscribeOn(sche)
    }

    override fun isLocalDataAvailable(): Boolean
    {
        return dbHelper.countAlbums() > 0 &&
                dbHelper.countPhotos() > 0 &&
                dbHelper.countUsers() > 0
    }
}
