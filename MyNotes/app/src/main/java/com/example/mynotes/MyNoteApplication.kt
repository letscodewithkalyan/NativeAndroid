package com.example.mynotes

import android.app.Application
import android.content.Context
import android.os.Build
import com.example.mynotes.utils.FileUtils
import com.example.mynotes.utils.Preferences
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@HiltAndroidApp
class MyNoteApplication : Application() {
    override fun onCreate() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            createConfigurationContext(FileUtils.getLocalConfig(this))
        }else{
            resources.updateConfiguration(FileUtils.getLocalConfig(this), resources.displayMetrics)
        }
        super.onCreate()
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase?.createConfigurationContext(FileUtils.getLocalConfig(newBase)))
    }
}