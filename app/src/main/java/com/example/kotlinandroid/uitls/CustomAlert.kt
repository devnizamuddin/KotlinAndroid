package com.example.kotlinandroid.uitls

import android.graphics.Color
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class CustomAlert {


    companion object{

        fun showSnackBar(view: View, message: String, actionName: String = "", function: () -> Unit={}) {

            val snackBar = Snackbar.make(view, message, Snackbar.LENGTH_LONG)
            snackBar.setActionTextColor(Color.BLACK)
            snackBar.setBackgroundTint(Color.BLUE)
            snackBar.setTextColor(Color.WHITE)

            if (!actionName.equals(""))
            {
                snackBar.setAction(actionName, { function })
            }
            snackBar.show()
        }

        fun showDialog(){

            //val builder :AlertDialog.Builder = AlertDialog

        }

    }


}