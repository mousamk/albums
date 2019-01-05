package pro.mousa.albums.ui.base

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean
import io.reactivex.disposables.CompositeDisposable
import pro.mousa.albums.data.DataManager
import pro.mousa.albums.utils.rx.SchedulerProvider
import java.lang.ref.WeakReference


open class BaseViewModel<Nav : BaseNavigator>(val dataManager: DataManager,
                                              val schedulerProvider: SchedulerProvider) : ViewModel()
{
    private var navigatorBack: WeakReference<Nav>? = null

    var navigator: Nav?
        get() = navigatorBack?.get()
        set(nav) { navigatorBack = if (null == nav) null else WeakReference(nav) }

    val disposables = CompositeDisposable()

    val isLoading = ObservableBoolean(false)


    override fun onCleared()
    {
        disposables.dispose()
        super.onCleared()
    }

    fun setIsLoading(loading: Boolean) = isLoading.set(loading)
}
