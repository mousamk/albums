package pro.mousa.albums.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import pro.mousa.albums.App


abstract class BaseFragment : Fragment()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        (context?.applicationContext as App).component.inject(this)
    }
}
