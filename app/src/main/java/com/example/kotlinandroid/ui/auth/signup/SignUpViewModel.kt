package com.example.kotlinandroid.ui.auth.signup

import android.app.Application
import android.content.Context
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.kotlinandroid.repository.AuthRepository
import com.example.kotlinandroid.uitls.CustomKey.Companion.TAG

class SignUpViewModel() : ViewModel() {

    var authRepository: AuthRepository = AuthRepository()

    fun signUpUser(email: String, password: String, confirmPassword: String) {

        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(email)) {

            if (password.equals(confirmPassword)) {

                authRepository.signUp(email, password)
            } else {
                Log.d(TAG, "signUpUser: Password doesn't match")
            }
        } else {
            Log.d(TAG, "signUpUser: All fields are required")
        }


    }


}