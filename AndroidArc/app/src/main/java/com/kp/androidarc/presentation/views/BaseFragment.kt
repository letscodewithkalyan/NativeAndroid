package com.kp.androidarc.presentation.views

import android.app.AlertDialog
import android.os.Bundle
import android.widget.ProgressBar
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {
    private lateinit var progressDialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        progressDialog = createProgressDialog()
    }

    private fun createProgressDialog(): AlertDialog {
        val progressBar = ProgressBar(this.context)
        return AlertDialog.Builder(this.context)
            .setView(progressBar)
            .setCancelable(false)
            .create()
    }

    fun showLoader() {
        if (!progressDialog.isShowing) progressDialog.show()
    }

    fun hideLoader() {
        if (progressDialog.isShowing) progressDialog.dismiss()
    }
}