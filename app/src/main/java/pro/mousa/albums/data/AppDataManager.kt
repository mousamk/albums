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
        return dbHelper.loadAlbums().flatMap { albums ->
            if (albums.isNotEmpty()) Single.just(albums)
            else apiHelper.getAlbums().flatMap { dbHelper.loadAlbums() }
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
        return apiHelper.getUsers()
            .flatMap { apiHelper.getAlbums() }
            .flatMap { apiHelper.getPhotos() }
            .flatMap { Single.just(true) }
    }

    override fun isLocalDataAvailable(): Boolean
    {
        return dbHelper.countAlbums() > 0 &&
                dbHelper.countPhotos() > 0 &&
                dbHelper.countUsers() > 0
    }
}

