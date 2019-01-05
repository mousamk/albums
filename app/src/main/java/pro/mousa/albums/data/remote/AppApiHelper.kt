package pro.mousa.albums.data.remote

import android.util.Log
import io.reactivex.Single
import pro.mousa.albums.Config
import pro.mousa.albums.data.local.DbHelper
import pro.mousa.albums.data.model.Album
import pro.mousa.albums.data.model.Photo
import pro.mousa.albums.data.model.User
import pro.mousa.albums.utils.rx.SchedulerProvider
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject


class AppApiHelper @Inject constructor(private val dbHelper: DbHelper,
                                       private val schedulerProvider: SchedulerProvider) : ApiHelper
{
    private val apiService: ApiService


    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(Config.API_ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        apiService = retrofit.create(ApiService::class.java)
    }

    override fun getAlbums(): Single<List<Album>>
    {
        return apiService.getAlbums().map { albums ->
            Log.i(TAG, "Downloaded ${albums.size} albums.")
            dbHelper.saveAlbums(albums)
            albums
        }.subscribeOn(schedulerProvider.io()).observeOn(schedulerProvider.ui())
    }

    override fun getPhotos(): Single<List<Photo>>
    {
        return apiService.getPhotos().map { photos ->
            Log.i(TAG, "Downloaded ${photos.size} photos.")
            dbHelper.savePhotos(photos)
            photos
        }.subscribeOn(schedulerProvider.io()).observeOn(schedulerProvider.ui())
    }

    override fun getUsers(): Single<List<User>>
    {
        return apiService.getUsers().map { users ->
            Log.i(TAG, "Downloaded ${users.size} users.")
            dbHelper.saveUsers(users)
            users
        }.subscribeOn(schedulerProvider.io()).observeOn(schedulerProvider.ui())
    }


    companion object
    {
        private val TAG: String = AppApiHelper::class.java.simpleName
    }
}
