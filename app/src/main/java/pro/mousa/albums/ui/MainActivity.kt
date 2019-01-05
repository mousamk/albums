package pro.mousa.albums.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle


class MainActivity : BaseActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setUp()
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
