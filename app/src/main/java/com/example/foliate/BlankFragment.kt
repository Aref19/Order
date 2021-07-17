package com.example.foliate

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foliate.adpter.RecyclerAdpter

import androidx.fragment.app.FragmentTransaction
import com.example.foliate.moldle.Items
import kotlinx.android.synthetic.main.adpter_foraddnewitem.view.*
import kotlin.math.log

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment : Fragment(), AdapterView.OnItemSelectedListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var vie: View? = null
    var name: EditText? = null
    var spinner: Spinner? = null
    var imagoficon: ImageView? = null
    var icon: Int? = null
    var nameofp: String? = null
    var rec: RecyclerView? = null
    var list: ArrayList<Items>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true);


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vie = inflater.inflate(R.layout.fragment_blank, container, false)
        return vie
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        vie = view
        rec = view.findViewById<RecyclerView>(R.id.recycl)

        rec!!.refreshDrawableState()
        rec!!.layoutManager = LinearLayoutManager(view.context)
        list = arrayListOf()

        super.onViewCreated(view, savedInstanceState)

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        val inflater = inflater.inflate(R.menu.add_item, menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.addpackeg -> {

                creatAlert()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    fun creatAlert() {
        var newview = View.inflate(vie!!.context, R.layout.adpter_foraddnewitem, null)
        name = newview.findViewById<EditText>(R.id.namepa)
        spinner = newview.findViewById<Spinner>(R.id.iconselect)
        imagoficon = newview.findViewById<ImageView>(R.id.iconselected)
        ArrayAdapter.createFromResource(
            vie!!.context,
            R.array.arraoficons,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner!!.adapter = adapter
        }
        spinner!!.onItemSelectedListener = this
        var alert = AlertDialog.Builder(vie!!.context)
            .setTitle("add new item ")
            .setView(newview)
        var dial = alert.show()


        newview.floating_check_fromview.setOnClickListener {
            it

            nameofp = name!!.text.toString()

            list!!.add(Items(nameofp!!, icon!!))
            Log.i("kks", "creatAlert: "+nameofp)
            var adpter = RecyclerAdpter(list!!)

            rec!!.adapter = adpter
            rec!!.refreshDrawableState()


            dial.dismiss()
        }
/*
        val newFragment = com.example.foliate.general.Dialog()
        val transaction = requireFragmentManager().beginTransaction()
        // For a little polish, specify a transition animation
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        // To make it fullscreen, use the 'content' root view as the container
        // for the fragment, which is always the root view for the activity
        transaction
            .add(R.id.c, newFragment)
            .addToBackStack(null)
            .commit()
    }

 */

    }


    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        Log.i("which", "onItemSelected: " + p0!!.getItemAtPosition(p2))

        whichItemisSeklected(p0!!.getItemAtPosition(p2).toString())

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }


    fun whichItemisSeklected(input: String) {
        var arry = resources.getStringArray(R.array.arraoficons)
        when (input) {
            arry[0] -> {
                imagoficon!!.setImageResource(R.drawable.ss)
                icon = R.drawable.ss
            }
            arry[1] -> {
                imagoficon!!.setImageResource(R.drawable.paket)
                icon = R.drawable.paket
            }
            arry[2] -> {
                imagoficon!!.setImageResource(R.drawable.order)
                icon = R.drawable.order
            }


        }

    }


}
