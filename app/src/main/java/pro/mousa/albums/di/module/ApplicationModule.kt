package pro.mousa.albums.di.module

import dagger.Module
import dagger.Provides
import pro.mousa.albums.data.AppDataManager
import pro.mousa.albums.data.DataManager
import pro.mousa.albums.data.local.AppDbHelper
import pro.mousa.albums.data.local.DbHelper
import pro.mousa.albums.data.remote.ApiHelper
import pro.mousa.albums.data.remote.AppApiHelper
import pro.mousa.albums.utils.rx.AppSchedulerProvider
import pro.mousa.albums.utils.rx.SchedulerProvider
import javax.inject.Singleton


//TODO: I think this needs to be removed!
@Module
class ApplicationModule
{
    @Provides
    @Singleton
    fun provideDbHelper(appDbHelper: AppDbHelper): DbHelper = appDbHelper

    @Provides
    @Singleton
    fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper = appApiHelper

    @Provides
    @Singleton
    fun provideDataManager(appDataManager: AppDataManager): DataManager = appDataManager

    @Provides
    fun provideSchedulerProviders(): SchedulerProvider = AppSchedulerProvider()
}
