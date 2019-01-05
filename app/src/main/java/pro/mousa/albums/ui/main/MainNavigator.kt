package pro.mousa.albums.ui.main

import pro.mousa.albums.ui.base.BaseNavigator


interface MainNavigator : BaseNavigator
{
    fun handleError(tr: Throwable)
}
