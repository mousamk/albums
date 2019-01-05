package pro.mousa.albums.ui.splash

import android.util.Log
import pro.mousa.albums.data.DataManager
import pro.mousa.albums.ui.base.BaseViewModel
import pro.mousa.albums.utils.rx.SchedulerProvider


class SplashViewModel(dataManager: DataManager,
                      schedulerProvider: SchedulerProvider)
    : BaseViewModel<SplashNavigator>(dataManager, schedulerProvider)
{
    fun startDownloading()
    {
        val disposable = dataManager.downloadIfRequired().subscribe({
            Log.d(TAG, "Opening main activity...")
            navigator?.openMainActivity()
        }, {
            Log.e(TAG, "An error happened checking data: ${it.message}")
            //TODO: Show error!
        })
        disposables.add(disposable)
    }


    companion object
    {
        private val TAG: String = SplashViewModel::class.java.simpleName
    }
}
