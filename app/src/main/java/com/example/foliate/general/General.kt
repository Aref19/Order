package com.example.foliate.general

import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Log
import android.widget.Toast
import com.example.foliate.interfaces.Firebase
import com.google.firebase.auth.FirebaseAuth


class General {
    var firbase:Firebase?=null
    companion object{
        fun checkpass(t1:String,t2:String):Boolean{
            Log.i("pass", "checkpass: "+t1+"t2 :"+t2)
            return t1.equals(t2)
        }


    }

    fun EmailRgistierenAndPass(email: String, pass: String) {
        private lateinit var auth: FirebaseAuth
// ...
// Initialize Firebase Auth
        auth = Firebase.auth
         auth
    }

}