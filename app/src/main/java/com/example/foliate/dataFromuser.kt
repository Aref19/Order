package com.example.foliate

import android.os.Bundle
import android.util.Log
import android.util.Patterns
import com.example.foliate.dataFromuser
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.foliate.Modell.FirbasViewModel
import com.example.foliate.R
import com.example.foliate.general.General
import com.example.foliate.interfaces.Firebase
import kotlinx.android.synthetic.main.fragment_data_fromuser.view.*
import java.util.regex.Pattern

/**
 * A simple [Fragment] subclass.
 * Use the [dataFromuser.newInstance] factory method to
 * create an instance of this fragment.
 */
class dataFromuser constructor() : Fragment(), Firebase {
    // TODO: Rename and change types of parameters
    private var mParam1: String? = null
    private var mParam2: String? = null
    var vie: View? = null

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (getArguments() != null) {
            /*
            mParam1 = it.getString(ARG_PARAM1)
            mParam2 = it.getString(ARG_PARAM2)

             */
        }
    }

    public override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        vie = inflater.inflate(R.layout.fragment_data_fromuser, container, false)
        return vie
    }

    public override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        registeren()



        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private val ARG_PARAM1: String = "param1"
        private val ARG_PARAM2: String = "param2"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment dataFromuser.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(param1: String?, param2: String?): dataFromuser {
            val fragment: dataFromuser = dataFromuser()
            val args: Bundle = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.setArguments(args)
            return fragment
        }
    }

    fun registeren() {

        vie!!.floating_check.setOnClickListener {
            if (checkPassowrdLong(
                    vie!!.passfromreg.editText?.text.toString(),
                    vie!!.emailfromReg.editText?.text.toString()
                )
            ) {
                var dataFromuser = vie!!.passfromreg.editText?.text.toString()
                var dataFromuserpass = vie!!.passwider.editText?.text.toString()
                if (General.checkpass(dataFromuser, dataFromuserpass)) {
                    var firbasViewModel = FirbasViewModel(
                        vie!!.emailfromReg.editText?.text.toString(),
                        vie!!.passwider.editText?.text.toString()
                    )

                    firbasViewModel.getRegistrationFirebase(this)
                } else {
                    Toast.makeText(vie!!.context, "palse check your input", Toast.LENGTH_LONG)
                        .show()
                    vie!!.emailfromReg.error = "Error"
                    vie!!.passwider.error = "Error"

                }

            }


        }

    }


    override fun withFirebaseRegistieren(task: Boolean) {
        if (task) {
            Toast.makeText(vie!!.context, "echt sucsses", Toast.LENGTH_LONG).show()
            Navigation.findNavController(vie!!).navigate(R.id.action_dataFromuser_to_blankFragment)
        } else {
            Toast.makeText(vie!!.context, "echt palse check your input", Toast.LENGTH_LONG).show()

        }
    }

    fun checkPassowrdLong(input: String, email: String): Boolean {
        var result: Boolean = false
        // check email

        var pattern = Regex("[a-zA-z0-9]+@[a-z]+\\.[a-z]{2,4}")


        if (pattern.containsMatchIn(email)) {
            if (input.length > 4) {

                var pattern = Regex("[a-zA-z]+[0-9]+")
                result = pattern.containsMatchIn(input)
                vie!!.passfromreg.error = null
            } else {
                vie!!.passfromreg.error = "Error"
                Toast.makeText(vie!!.context, "your pass should be longer", Toast.LENGTH_SHORT)
                    .show()
            }

        } else {
            vie!!.emailfromReg.error = "Error"
            Toast.makeText(vie!!.context, "check your email", Toast.LENGTH_SHORT).show()
        }

        //check pass


        return result

    }


}