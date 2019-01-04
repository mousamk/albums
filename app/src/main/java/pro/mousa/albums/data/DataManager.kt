package pro.mousa.albums.data

import io.reactivex.Single
import pro.mousa.albums.data.model.Album
import pro.mousa.albums.data.model.Photo


interface DataManager
{
    fun getAlbums(): Single<List<Album>>
    fun getAlbumPhotos(albumId: Long): Single<List<Photo>>
}
