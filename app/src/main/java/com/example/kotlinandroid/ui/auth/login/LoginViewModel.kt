package com.example.kotlinandroid.ui.auth.login

import android.app.Application
import android.content.Context
import android.text.TextUtils
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinandroid.repository.AuthRepository

class LoginViewModel() : ViewModel() {


    val authRepository: AuthRepository = AuthRepository()

    fun loginUser(
        email: String,
        password: String,
    ): MutableLiveData<String> {

        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {

            return authRepository.login(email, password)
        } else {
        }
        return authRepository.login(email, password)


    }

}