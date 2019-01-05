package pro.mousa.albums.ui.base

import android.app.Activity


/**
 * This is the base class for activities in this application. It exists to hold the shared
 * properties and also provide a common class for dependencies to hook on.
 */
abstract class BaseActivity<out V : BaseViewModel<out BaseNavigator>> : Activity()
{
    abstract val layoutId: Int
    abstract val viewModel: V
}
