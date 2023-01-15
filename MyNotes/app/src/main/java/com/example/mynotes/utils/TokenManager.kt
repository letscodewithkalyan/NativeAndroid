package com.example.mynotes.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.mynotes.utils.Constants.PREFS_TOKEN_FILE
import com.example.mynotes.utils.Constants.USER_TOKEN
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class TokenManager @Inject constructor(@ApplicationContext context: Context)  {
    private var prefs: SharedPreferences = context.getSharedPreferences(PREFS_TOKEN_FILE, Context.MODE_PRIVATE)

    fun saveToken(token: String){
        prefs.edit().putString(USER_TOKEN,token).apply();
    }

    fun getToken(): String?{
        return  prefs.getString(USER_TOKEN,null);
    }
}