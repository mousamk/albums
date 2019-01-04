package pro.mousa.albums

import android.os.Bundle
import pro.mousa.albums.data.ui.BaseActivity


class MainActivity : BaseActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
