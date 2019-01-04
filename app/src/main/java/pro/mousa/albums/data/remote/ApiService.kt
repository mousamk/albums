package pro.mousa.albums.data.remote

import io.reactivex.Single
import pro.mousa.albums.data.model.Album
import pro.mousa.albums.data.model.Photo
import pro.mousa.albums.data.model.User
import retrofit2.http.GET


interface ApiService
{
    @GET("/albums")
    fun getAlbums(): Single<List<Album>>

    @GET("/photos")
    fun getPhotos(): Single<List<Photo>>

    @GET("/users")
    fun getUsers(): Single<List<User>>
}
