package com.example.mynotes.utils

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import android.media.audiofx.DynamicsProcessing.Config
import android.net.Uri
import android.os.Environment
import androidx.core.content.FileProvider
import com.example.mynotes.R
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

object FileUtils {

    /**
     * Get Current Time in yyyyMMdd HHmmssSSS format
     *
     * 2019/01/30 10:30:20 000
     * E.g. 20190130_103020000
     */
    private fun getTimestamp(): String {
        val timeFormat = "yyyyMMdd_HHmmssSSS"
        return SimpleDateFormat(timeFormat, Locale.getDefault()).format(Date())
    }

    fun getImageUri(context: Context) : Uri? {
        try {
            val imageFileName = "IMG_${getTimestamp()}.jpg"

            // Create File Directory Object
            val storageDir = getCameraDirectory(context)

            // Create Directory If not exist
            if (!storageDir.exists()) storageDir.mkdirs()

            // Create File Object
            val file = File(storageDir, imageFileName);

            // Create empty file
            file.createNewFile()

            val authority =
                context.packageName + context.getString(R.string.image_picker_provider_authority_suffix)

            val uriForFile = FileProvider.getUriForFile(context, authority, file)

            return uriForFile
        }catch (ex: Exception){
            ex.printStackTrace()
            return null
        }
    }

    /**
     * Get Camera Image Directory
     *
     * @return File Camera Image Directory
     */
    private fun getCameraDirectory(context: Context): File {
        val dir =
            context.getExternalFilesDir(Environment.DIRECTORY_DCIM) // Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM)
        return File(dir, "Camera")
    }

    fun getLocalConfig(context: Context) : Configuration {
        var preferences = context.getSharedPreferences(Constants.SHARED_PREFS,Context.MODE_PRIVATE)
        var selectedLang = preferences.getString(Constants.USER_LANGUAGE, "")
        selectedLang = if(selectedLang.isNullOrEmpty()) "en" else  selectedLang
        var config = context.resources.configuration
        config.setLocale(Locale(selectedLang))
        config.setTo(config)
        return config
    }
}