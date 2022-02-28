package com.example.kotlinandroid.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinandroid.R
import com.example.kotlinandroid.ui.auth.login.LoginFragment
import com.example.kotlinandroid.ui.auth.signup.SignupFragment
import com.example.kotlinandroid.uitls.ManageFragment

class AuthActivity : AppCompatActivity() {

    val manageFragment: ManageFragment = ManageFragment(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        manageFragment.changeFragment(LoginFragment(),R.id.auth_container)

    }
}