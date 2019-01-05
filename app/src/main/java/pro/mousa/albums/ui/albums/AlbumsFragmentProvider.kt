package pro.mousa.albums.ui.albums

import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class AlbumsFragmentProvider
{
    @ContributesAndroidInjector(modules = [AlbumsFragmentModule::class])
    abstract fun provideAlbumsFragmentFactory(): AlbumsFragment
}
