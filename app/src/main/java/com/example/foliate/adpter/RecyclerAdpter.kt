package com.example.foliate.adpter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foliate.R
import com.example.foliate.moldle.Items

class RecyclerAdpter(list:ArrayList<Items>) : RecyclerView.Adapter<RecyclerAdpter.ViewHolder>() {
    var items=list
    class ViewHolder (view: View): RecyclerView.ViewHolder(view) {
        var image=view.findViewById<ImageView>(R.id.iconad)
        var name=view.findViewById<TextView>(R.id.namead)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdpter.ViewHolder {
        var v=LayoutInflater.from(parent.context).inflate(R.layout.adpterforrecycler,parent,false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdpter.ViewHolder, position: Int) {
        holder.image.setImageResource(items.get(position).res)
        holder.name.text=items.get(position).name
        Log.i("hiii", "onBindViewHolder: "+items.get(position).name)
    }

    override fun getItemCount(): Int {
       return items.size
    }
}