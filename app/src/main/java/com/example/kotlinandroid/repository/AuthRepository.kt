package com.example.kotlinandroid.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.kotlinandroid.uitls.CustomKey.Companion.SUCCESSFUL
import com.example.kotlinandroid.uitls.CustomKey.Companion.TAG
import com.google.android.gms.tasks.OnCanceledListener
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class AuthRepository() {


    val auth = FirebaseAuth.getInstance()
    var response:MutableLiveData<String> = MutableLiveData()
    val database = FirebaseDatabase.getInstance();
    val statusReference = database.getReference("Status")

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

    fun manageStatus(){

      val conectionReference:DatabaseReference = database.reference.child("connections")
      val lastConnected:DatabaseReference = database.reference.child("lastConnected")
      val infoConnected:DatabaseReference = database.reference.child(".info/connected")

        val valueEventListener = object :ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {
               val connected = snapshot.getValue() as Boolean
                if (connected){
                    val con = conectionReference.child("123")
                    con.setValue(true)
                    con.onDisconnect().setValue(true)
                }

            }

            override fun onCancelled(error: DatabaseError) {
                Log.d(TAG, "onCancelled: ${error.message}")
            }
        }

        infoConnected.addValueEventListener(valueEventListener)

    }

}

