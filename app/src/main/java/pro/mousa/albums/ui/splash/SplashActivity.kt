package pro.mousa.albums.ui.splash

import android.os.Bundle
import pro.mousa.albums.BR
import pro.mousa.albums.R
import pro.mousa.albums.databinding.ActivitySplashBinding
import pro.mousa.albums.ui.base.BaseActivity
import pro.mousa.albums.ui.main.MainActivity
import javax.inject.Inject


class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>(), SplashNavigator
{
    @Inject lateinit var splashViewModel: SplashViewModel

    override val layoutId: Int
        get() = R.layout.activity_splash

    override val viewModel: SplashViewModel
        get() = splashViewModel

    override val bindingVariable: Int
        get() = BR.viewModel


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        splashViewModel.navigator = this
        splashViewModel.startDownloading()
    }

    override fun openMainActivity()
    {
        startActivity(MainActivity.newIntent(this))
        finish()
    }
}
