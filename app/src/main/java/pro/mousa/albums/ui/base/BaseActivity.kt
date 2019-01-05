package pro.mousa.albums.ui.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection


/**
 * This is the base class for activities in this application. It exists to hold the shared
 * properties and also provide a common class for dependencies to hook on.
 */
abstract class BaseActivity<out B : ViewDataBinding, out V : BaseViewModel<out BaseNavigator>>
    : AppCompatActivity(), BaseFragment.Callback
{
    private var viewModelBack: V? = null
    private lateinit var viewDataBinding: B
    abstract val viewModel: V
    abstract val layoutId: Int
    abstract val bindingVariable: Int


    override fun onCreate(savedInstanceState: Bundle?)
    {
        performDependencyInjection()
        super.onCreate(savedInstanceState)
        performDataBinding()
    }

    private fun performDependencyInjection()
    {
        AndroidInjection.inject(this)
    }

    private fun performDataBinding()
    {
        viewDataBinding = DataBindingUtil.setContentView(this, layoutId)
        if (viewModelBack == null) viewModelBack = viewModel
        viewDataBinding.setVariable(bindingVariable, viewModelBack)
        viewDataBinding.executePendingBindings()
    }

    override fun onFragmentAttached() {}

    override fun onFragmentDetached(tag: String) {}
}
