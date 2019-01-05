package pro.mousa.albums.ui.main

import pro.mousa.albums.data.DataManager
import pro.mousa.albums.ui.base.BaseViewModel
import pro.mousa.albums.utils.rx.SchedulerProvider


class MainViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider)
    : BaseViewModel<MainNavigator>(dataManager, schedulerProvider)
{
}
