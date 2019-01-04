package pro.mousa.albums.di.module

import dagger.Module
import dagger.Provides
import pro.mousa.albums.data.local.AppDbHelper
import pro.mousa.albums.data.local.DbHelper
import pro.mousa.albums.data.remote.ApiHelper
import pro.mousa.albums.data.remote.AppApiHelper
import javax.inject.Singleton


@Module
class ApplicationModule
{
    @Provides
    @Singleton
    fun provideDbHelper(appDbHelper: AppDbHelper): DbHelper = appDbHelper

    @Provides
    @Singleton
    fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper = appApiHelper
}
