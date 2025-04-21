package com.spvag.simplekmmproject.android.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    var phoneNumber by mutableStateOf("")
        private set

    var password by mutableStateOf("")
        private set

    fun updatePhoneNumber(newPhoneNumber: String) {
        phoneNumber = newPhoneNumber
    }

    fun updatePassword(newPassword: String) {
        password = newPassword
    }
} 