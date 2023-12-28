package com.example.mynotes

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mynotes.utils.FileUtils
import com.example.mynotes.utils.Preferences
import com.example.mynotes.utils.TokenManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    //Faced issues with the DI of prefences into get config
    //Before base.Oncreate preferences not created.
    @Inject lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            createConfigurationContext(FileUtils.getLocalConfig(this))
        }else{
            resources.updateConfiguration(FileUtils.getLocalConfig(this), resources.displayMetrics)
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun attachBaseContext(newBase: Context?) {
      super.attachBaseContext(newBase?.createConfigurationContext(FileUtils.getLocalConfig(newBase)))
    }
}