package com.example.mynotes.models

import android.provider.ContactsContract.CommonDataKinds.Email

data class UserRequest(val email: String, val password: String, val username: String)
