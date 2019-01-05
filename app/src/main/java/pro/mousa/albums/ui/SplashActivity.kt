package pro.mousa.albums.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import pro.mousa.albums.R


class SplashActivity : BaseActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        downloadData()
    }

    private fun downloadData()
    {
        val disposable = dataManager.downloadIfRequired().subscribe({
            gotoMainActivity()
        }, {
            Log.e(TAG, "An error happened checking data: ${it.message}")
            Toast.makeText(this, "Couldn't download data!", Toast.LENGTH_LONG).show()
            //TODO: ...
        })
        disposables.add(disposable)
    }

    private fun gotoMainActivity()
    {
        Log.d(TAG, "Opening main activity...")
        startActivity(MainActivity.newIntent(this))
        finish()
    }


    companion object
    {
        private val TAG: String = SplashActivity::class.java.simpleName
    }
}
