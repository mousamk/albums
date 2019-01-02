package pro.mousa.albums.data.local

import io.reactivex.Single
import pro.mousa.albums.data.model.Album
import pro.mousa.albums.data.model.Photo
import pro.mousa.albums.data.model.User


interface DbHelper
{
    fun saveAlbums(albums: List<Album>): Single<Boolean>
    fun savePhotos(photos: List<Photo>): Single<Boolean>
    fun saveUsers(users: List<User>): Single<Boolean>

    fun loadAlbums(): Single<List<Album>>
    fun loadPhotosByAlbum(albumId: Long): Single<List<Photo>>
    fun loadUserById(userId: Long): Single<User>
}
