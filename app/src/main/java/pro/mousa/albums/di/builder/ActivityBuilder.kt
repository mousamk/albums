package pro.mousa.albums.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pro.mousa.albums.ui.splash.SplashActivity
import pro.mousa.albums.ui.splash.SplashActivityModule


@Module
abstract class ActivityBuilder
{
    @ContributesAndroidInjector(modules = [SplashActivityModule::class])
    abstract fun bindSplashActivity(): SplashActivity
}
