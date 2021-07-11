package com.example.foliate.general


import android.content.Context
import android.util.Log

import com.example.foliate.interfaces.Firebase
import com.google.firebase.auth.FirebaseAuth


class General {
    var firbase: Firebase? = null



    companion object {
        fun checkpass(t1: String, t2: String): Boolean {
            Log.i("pass", "checkpass: " + t1 + "t2 :" + t2)
            return t1.equals(t2)
        }


    }

  suspend  fun EmailRgistierenAndPass(email: String, pass: String,con:Firebase) {
        val auth=FirebaseAuth.getInstance()
        Log.i("why", "EmailRgistierenAndPass: "+email+"pass :" +pass)
           firbase=con
           auth.createUserWithEmailAndPassword(email.trim(),pass)
            .addOnCompleteListener {it
                if(it.isSuccessful)
                    firbase!!.withFirebaseRegistieren(true)
                else{
                    firbase!!.withFirebaseRegistieren(false)


                }



            }


    }

}