package com.example.mynotes.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.mynotes.utils.Constants.SHARED_PREFS
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Preferences @Inject constructor(@ApplicationContext context: Context) {
    private var prefs: SharedPreferences = context.getSharedPreferences(SHARED_PREFS,Context.MODE_PRIVATE)
    fun saveString(key: String, value: String){
        prefs.edit().putString(key, value).apply()
    }

    fun getString(key: String) : String?{
        return prefs.getString(key,null)
    }
}