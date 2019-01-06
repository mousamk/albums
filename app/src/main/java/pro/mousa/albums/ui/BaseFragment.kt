package pro.mousa.albums.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import io.reactivex.disposables.CompositeDisposable
import pro.mousa.albums.App
import pro.mousa.albums.data.DataManager
import javax.inject.Inject


abstract class BaseFragment : Fragment()
{
    @Inject internal lateinit var dataManager: DataManager
    protected val disposables = CompositeDisposable()


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        (context?.applicationContext as App).component.inject(this)
    }

    override fun onDestroy()
    {
        super.onDestroy()
        disposables.dispose()
    }

    open fun handleBackPress(): Boolean = false
}
