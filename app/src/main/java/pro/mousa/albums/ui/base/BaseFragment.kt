package pro.mousa.albums.ui.base

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.AndroidSupportInjection


abstract class BaseFragment<out B : ViewDataBinding, out V : BaseViewModel<out BaseNavigator>> : Fragment()
{
    private var activity: BaseActivity<B, V>? = null
    private lateinit var rootView: View
    private var viewModelBack: V? = null
    private lateinit var viewDataBinding: B
    abstract val viewModel: V
    abstract val layoutId: Int
    abstract val bindingVariable: Int

    protected val baseActivity: BaseActivity<B, V>? get() = activity


    override fun onAttach(context: Context?)
    {
        super.onAttach(context)
        if (context is BaseActivity<*,*>) {
            activity = context as BaseActivity<B, V>?
            activity?.onFragmentAttached()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        performDependencyInjection()
        super.onCreate(savedInstanceState)
        viewModelBack = viewModel
        setHasOptionsMenu(false)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        viewDataBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        rootView = viewDataBinding.root
        return rootView
    }

    override fun onDetach()
    {
        activity = null
        super.onDetach()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.setVariable(bindingVariable, viewModel)
        viewDataBinding.executePendingBindings()
    }

    private fun performDependencyInjection()
    {
        AndroidSupportInjection.inject(this)
    }


    interface Callback
    {
        fun onFragmentAttached()
        fun onFragmentDetached(tag: String)
    }
}
