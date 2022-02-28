package com.example.kotlinandroid.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.kotlinandroid.uitls.CustomKey.Companion.SUCCESSFUL
import com.example.kotlinandroid.uitls.CustomKey.Companion.TAG
import com.google.android.gms.tasks.OnCanceledListener
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth

class AuthRepository() {


    val auth = FirebaseAuth.getInstance()
    var response:MutableLiveData<String> = MutableLiveData()

    fun signUp(email:String,password:String) {

        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener{
            task->
            if (task.isSuccessful){
                Log.d(TAG, "signUp: Successful")
                response.value = SUCCESSFUL

            }
            else{
                Log.d(TAG, "signUp: ${task.exception?.localizedMessage}")
                response.value = task.exception?.localizedMessage
            }
        }.addOnCanceledListener(OnCanceledListener {  })
    }
    
    fun login(email: String,password: String):MutableLiveData<String>{
        
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(OnCompleteListener { task->
            
            if (task.isSuccessful){
                Log.d(TAG, "login: Successful")
                response.value = SUCCESSFUL

            }
            else{
                Log.d(TAG, "login: ${task.exception?.localizedMessage}")
                response.value = task.exception?.localizedMessage

            }
        })

        return response
        
    }

}

