package pro.mousa.albums.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pro.mousa.albums.ui.albums.AlbumsFragmentProvider
import pro.mousa.albums.ui.main.MainActivity
import pro.mousa.albums.ui.main.MainActivityModule
import pro.mousa.albums.ui.splash.SplashActivity
import pro.mousa.albums.ui.splash.SplashActivityModule


@Module
abstract class ActivityBuilder
{
    @ContributesAndroidInjector(modules = [SplashActivityModule::class])
    abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector(modules = [
        AlbumsFragmentProvider::class,
        MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity
}
