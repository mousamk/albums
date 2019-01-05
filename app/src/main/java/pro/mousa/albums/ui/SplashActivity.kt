package pro.mousa.albums.ui

import android.os.Bundle
import pro.mousa.albums.R


class SplashActivity : BaseActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    fun openMainActivity()
    {
        startActivity(MainActivity.newIntent(this))
        finish()
    }
}
