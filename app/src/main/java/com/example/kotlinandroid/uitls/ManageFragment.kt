package com.example.kotlinandroid.uitls

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

class ManageFragment (val fragmentActivity: FragmentActivity) {

    fun changeFragment(fragment: Fragment, layoutId:Int) {
       val transaction =  fragmentActivity.supportFragmentManager.beginTransaction()
        transaction.replace(layoutId,fragment)
        transaction.commit()
    }

     fun changeFragmentWithBackStack(fragment: Fragment, layoutId:Int,tag:String?) {
        val transaction =  fragmentActivity.supportFragmentManager.beginTransaction()
        transaction.replace(layoutId,fragment).addToBackStack(tag)
        transaction.commit()
    }
    
}