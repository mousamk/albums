package pro.mousa.albums.ui.main

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import pro.mousa.albums.BR
import pro.mousa.albums.R
import pro.mousa.albums.databinding.ActivityMainBinding
import pro.mousa.albums.ui.base.BaseActivity
import javax.inject.Inject


class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), MainNavigator//, HasSupportFragmentInjector
{
//    @Inject internal lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    @Inject internal lateinit var viewModelFactory: ViewModelProvider.Factory

    private var mainViewModel: MainViewModel? = null
    private lateinit var activityMainBinding: ActivityMainBinding

    override val viewModel: MainViewModel
        get() {
            val viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
            mainViewModel = viewModel
            return viewModel
        }

    override val layoutId: Int
        get() = R.layout.activity_main

    override val bindingVariable: Int
        get() = BR.viewModel


//    override fun supportFragmentInjector() = fragmentDispatchingAndroidInjector

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        activityMainBinding = viewDataBinding
        mainViewModel?.navigator = this
        setUp()
    }

    override fun handleError(tr: Throwable)
    {
        //...
    }

    private fun setUp()
    {
        //...
    }


    companion object
    {
        fun newIntent(context: Context) = Intent(context, MainActivity::class.java)
    }
}
