package pro.mousa.albums.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import pro.mousa.albums.App
import pro.mousa.albums.data.DataManager
import pro.mousa.albums.utils.rx.SchedulerProvider
import javax.inject.Inject


/**
 * This is the base class for activities in this application. It exists to hold the shared
 * properties and also provide a common class for dependencies to hook on.
 */
abstract class BaseActivity : AppCompatActivity()
{
    @Inject internal lateinit var dataManager: DataManager
    @Inject internal lateinit var schedulerProvider: SchedulerProvider
    protected val disposables = CompositeDisposable()


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        (application as App).component.inject(this)
    }

    override fun onDestroy()
    {
        disposables.dispose()
        super.onDestroy()
    }
}
