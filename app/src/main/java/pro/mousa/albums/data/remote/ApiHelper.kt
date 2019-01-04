package pro.mousa.albums.data.remote

import io.reactivex.Single
import pro.mousa.albums.data.model.Album
import pro.mousa.albums.data.model.Photo
import pro.mousa.albums.data.model.User


interface ApiHelper
{
    fun getAlbums(): Single<List<Album>>
    fun getPhotos(): Single<List<Photo>>
    fun getUsers():  Single<List<User>>
}
