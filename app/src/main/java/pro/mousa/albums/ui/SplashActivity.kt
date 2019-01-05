package pro.mousa.albums.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import pro.mousa.albums.R

import kotlinx.android.synthetic.main.activity_splash.*
import java.util.concurrent.TimeUnit


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
        val disposable = dataManager.downloadData()
            .delay(1000, TimeUnit.MILLISECONDS, schedulerProvider.ui(), true)
            .subscribe(
                { gotoMainActivity() },
                { tr ->
                    Log.e(TAG, "An error happened checking data: ${tr.message}")
                    if (dataManager.isLocalDataAvailable()) {
                        Toast.makeText(this, "Download problem! Showing offline data.", Toast.LENGTH_LONG).show()
                        gotoMainActivity()
                    }
                    else {
                        Toast.makeText(this, "Error downloading data! Please retry later.", Toast.LENGTH_LONG).show()
                        loading_spinner.visibility = View.INVISIBLE
                    }
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
