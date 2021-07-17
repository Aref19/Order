package com.example.foliate.general


import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.DialogFragment

import com.example.foliate.R

class Dialog : DialogFragment(){
    var v:View?=null
    var namepackge:EditText?=null
    var image:ImageView?=null
    var spinner:Spinner?=null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        v=inflater.inflate(R.layout.adpter_foraddnewitem,container,false)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        namepackge=view.findViewById(R.id.namepa)
        image=view.findViewById(R.id.iconselected)
        spinner=view.findViewById(R.id.iconselect)
        ArrayAdapter.createFromResource(v!!.context, R.array.arraoficons, android.R.layout.simple_spinner_item).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner!!.adapter = adapter
        }

        super.onViewCreated(view, savedInstanceState)
    }


}