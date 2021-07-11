package com.example.foliate.Modell

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.foliate.general.General
import com.example.foliate.interfaces.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class FirbasViewModel(email: String, pass: String) : ViewModel() {
    var email = email
    var pass = pass
    var genral: General = General()
    fun getRegistrationFirebase(con:Firebase) {
     GlobalScope.launch(Dispatchers.IO) {
            genral.EmailRgistierenAndPass(email, pass,con)

    }

    }


}