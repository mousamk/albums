package pro.mousa.albums.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import pro.mousa.albums.App


/**
 * This is the base class for activities in this application. It exists to hold the shared
 * properties and also provide a common class for dependencies to hook on.
 */
abstract class BaseActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        (application as App).component.inject(this)
    }
}
