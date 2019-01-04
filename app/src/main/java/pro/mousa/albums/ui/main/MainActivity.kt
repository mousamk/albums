package pro.mousa.albums.ui.main

import android.os.Bundle
import pro.mousa.albums.R
import pro.mousa.albums.ui.base.BaseActivity


class MainActivity : BaseActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
