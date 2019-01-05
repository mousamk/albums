package pro.mousa.albums

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider


class ViewModelProviderFactory<out V : Any>(private val viewModel: V) : ViewModelProvider.Factory
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T
    {
        if (modelClass.isAssignableFrom(viewModel.javaClass))
            return viewModel as T
        throw IllegalArgumentException("Unknown class name")
    }
}
